package APITesting.ContractValidaion;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import APITesting.ContractValidaion.Data;
import APITesting.ContractValidaion.User;

//import APITesting.ContractValidaion.Support;
import com.fasterxml.jackson.core.type.TypeReference;

public class apiOperations 
{
	ObjectMapper mapper= new ObjectMapper();
	public apiOperations() {

	}
	User user;
	public Response CallEndPoint(String type,String endPointMethod)
	{
		Response response=null ;
		String endpoint=Utility.endPoints.get(endPointMethod);
		switch (type.toLowerCase()) {

		case "get":
			response = Utility.request.get(endpoint);
			break;

		case "post":
			Utility.request.body(user);
			response = Utility.request.post(endpoint);
			break;

		case "put":
			Utility.request.body(user);
			response = Utility.request.put(endpoint);
			break;

		case "patch":
			Utility.request.body(user);
			response = Utility.request.patch(endpoint);
			break;

		case "delete":
			response = Utility.request.delete(endpoint);
			break;	

		default:
			break;
		}
		//Response response = Utility.request.get(endpoint);
		return response;
	}

	public Data GetUserDetails(Object object) throws JsonMappingException, JsonProcessingException
	{
		Response response=(Response) object;
		ResponseBody<?> responseBody =response.getBody();		
		JsonNode jsonNode = mapper.readTree(responseBody.asString());
		Data data= mapper.readValue(jsonNode.get("data").toString(), Data.class);
		//		Support support= mapper.readValue(jsonNode.get("support").toString(), Support.class);
		return data;
	}

	public List<Data> GetMultipleUserDetails(Object object) throws JsonMappingException, JsonProcessingException
	{
		Response response=(Response) object;
		ResponseBody<?> responseBody =response.getBody();		
		JsonNode jsonNode = mapper.readTree(responseBody.asString());
		List<Data> data=mapper.readValue(jsonNode.get("data").toString(),new TypeReference<List<Data>>(){});
		return data;
	}

	public void FormBody(String name, String job)
	{
		user= new User(name,job);	
	}

	public User GetUser(Object object)
	{
		Response response=(Response) object;
		User user=response.getBody().as(User.class);
		return user;
	}
}

class Utility
{
	public static final String BASE_URL="https://reqres.in/api";
	static Map<String, String> endPoints= new HashMap<>();
	static RequestSpecification request=RestAssured.given(); 
	static
	{
		request.baseUri(BASE_URL);
		request.header("Content-Type", "application/json");
		endPoints.put("GETUsers", "/users?page=2");
		endPoints.put("GETSingleUser", "/users/2");
		endPoints.put("UserNotFound", "/users/23");
		endPoints.put("CreateUser", "/users");
		endPoints.put("UpdateUserPUT", "/users/2");
		endPoints.put("DeleteUser", "/users/2");
		endPoints.put("UpdateUserPATCH", "/users/2");
	}
}