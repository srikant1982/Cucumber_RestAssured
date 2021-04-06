package APITesting.ContractValidaion;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown=true)
public class Data {

	@JsonProperty(value="id")
	public String id;
	
	@JsonProperty(value="email")
	public String email;
	
	@JsonProperty(value="first_name")
	public String first_name;
	
	@JsonProperty(value="last_name")
	public String last_name;
	
	@JsonProperty(value="avatar")
	public String avatar;

	public Data() 
	{
	}

	/**
	 *
	 * @param firstName
	 * @param lastName
	 * @param id
	 * @param avatar
	 * @param email
	 */
	public Data(String id, String email, String firstName, String lastName, String avatar) 
	{
	//	super();
		this.id = id;
		this.email = email;
		this.first_name = firstName;
		this.last_name = lastName;
		this.avatar=avatar;
	}
}

@JsonIgnoreProperties(ignoreUnknown=true)
class Support {
	@JsonProperty(value="url")
	public String url;
	
	@JsonProperty(value="text")
	public String text;

	/**
	 * No args constructor for use in serialization
	 *
	 */
	public Support() {
	}

	/**
	 *
	 * @param text
	 * @param url
	 */
	public Support(String url, String text) {
		super();
		this.url = url;
		this.text = text;
	}
}