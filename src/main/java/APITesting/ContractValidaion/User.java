package APITesting.ContractValidaion;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown=true)
public class User
{
	@JsonProperty(value="name")
	public String name;
	
	@JsonProperty(value="job")
	public String job;
	
	@JsonProperty(value="id")
	public String id;
	
	@JsonProperty(value="createdAt")
	public String createdAt;
	
	@JsonProperty(value="updatedAt")
	public String updatedAt;
	
	public User() {
	}
	
	public User(String name,String job)
	{
		this.name=name;
		this.job=job;
	}
	
	public User(String name,String job,String id,String createdAt)
	{
		this.name=name;
		this.job=job;
		this.id=id;
		this.createdAt=createdAt;
	}
	
	public User(String name,String job,String updatedAt)
	{
		this.name=name;
		this.job=job;
		this.updatedAt=createdAt;
	}
}