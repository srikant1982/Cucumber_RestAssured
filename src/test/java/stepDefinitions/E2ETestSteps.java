package stepDefinitions;

import java.util.List;
import org.junit.Assert;
import APITesting.ContractValidaion.Data;
import APITesting.ContractValidaion.User;
import APITesting.ContractValidaion.apiOperations;
import APITesting.ContractValidaion.scenarioContext;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;

public class E2ETestSteps
{
	apiOperations operation= new apiOperations();
	scenarioContext context= new scenarioContext();

	@Given("^I have access to end points$")
	public void i_have_access_to_end_points() throws Throwable {
		System.out.println("Accessible");
	}

	@When("^I \"([^\"]*)\" \"([^\"]*)\" end point$")
	public void i_call_something_end_point(String type,String endPoint) throws Throwable {
		Response response=operation.CallEndPoint(type,endPoint);
		Assert.assertNotNull(response);
		String statusLine=response.getStatusLine();
		int statusCode=response.getStatusCode();
		context.setContext("GetUserStatusCode", statusCode);
		context.setContext("GetUserStatusLine", statusLine);
		context.setContext("apiResponse", response);
	}

	@Then("^I get \"([^\"]*)\" status$")
	public void i_get_something_status(String status) throws Throwable {
		Assert.assertTrue(context.getContext("GetUserStatusLine").toString().contains(status));
	}

	@And("^I get \"([^\"]*)\" response$")
	public void i_get_something_response(String statusCode) throws Throwable {
		Assert.assertEquals(statusCode, context.getContext("GetUserStatusCode").toString());
	}

	@Then("^I get the user details$")
	public void i_get_the_user_details() throws Throwable {
		Data userData=operation.GetUserDetails(context.getContext("apiResponse"));
		Assert.assertEquals("Janet", userData.first_name);
		Assert.assertEquals("Weaver",userData.last_name);
	}

	@Then("^I verify multiple user details are returned$")
	public void i_verify_multiple_user_details_are_returned() throws Throwable {
		List<Data> userData=operation.GetMultipleUserDetails(context.getContext("apiResponse"));
		Assert.assertTrue(userData.size()>1);
	}

	@When("^I call \"([^\"]*)\" for \"([^\"]*)\" end point for \"([^\"]*)\" name and \"([^\"]*)\" job$")
	public void i_call_something_for_something_end_point_for_something_name_and_something_job(String type,String endPoint, String name, String job) throws Throwable {
		operation.FormBody(name, job);
		i_call_something_end_point(type, endPoint);
	}
	
    @Then("^I verify user details for \"([^\"]*)\" name and \"([^\"]*)\" job$")
    public void i_verify_user_details_for_something_name_and_something_job(String name, String job) throws Throwable {
    	User user=operation.GetUser(context.getContext("apiResponse"));
    	Assert.assertEquals(name, user.name);
    	Assert.assertEquals(job, user.job);
    	Assert.assertTrue(user.createdAt!=null || user.updatedAt!=null);
    	System.out.println(user.createdAt);
    	System.out.println(user.updatedAt);
    }
}
