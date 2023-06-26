package p_api.generalApiJsonObj;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
// parse & convert jsonResponseFromApi into a Java Object


public class TestingResponse {
	
	public static TestingResponse gsonFromJson(String jsonResponseFromApi) {
	Gson gson = new Gson(); // Create the needed Gson object
	return gson.fromJson(jsonResponseFromApi, TestingResponse.class);	
	}
	
	//	JSON fields
	@SerializedName("Data")
	private static Data Data;

	@SerializedName("Support")
	private static Support Support;
	
	//	constructor

	//	get & set +
	public static Data getData() {
		return TestingResponse.Data;
	}
	public static Support getSupport() {
		return TestingResponse.Support;
	}
	public void setData(Data data) {
		TestingResponse.Data = data;
	}
	public void setSupport(Support support) {
		TestingResponse.Support = support;
	}
}

class Support {
	
	//	JSON fields
	@SerializedName("url")
	private String url;
	@SerializedName("text")
	private String text;

	//	constructor

	//	get & set +
	public String getUrl() {
		return url;
	}
	public String getText() {
		return text;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public void setText(String text) {
		this.text = text;
	}
}

class Data {
	
	//	JSON fields
	@SerializedName("id")
	private float id;
	@SerializedName("email")
	private String email;
	@SerializedName("first_name")
	private String first_name;
	@SerializedName("last_name")
	private String last_name;
	@SerializedName("avatar")
	private String avatar;

	//	constructor

	//	get & set +
	public float getId() {
		return id;
	}
	public String getEmail() {
		return email;
	}
	public String getFirst_name() {
		return first_name;
	}
	public String getLast_name() {
		return last_name;
	}
	public String getAvatar() {
		return avatar;
	}
	public void setId(float id) {
		this.id = id;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	public void setAvatar( String avatar ) {
		    this.avatar = avatar;
	}
}
