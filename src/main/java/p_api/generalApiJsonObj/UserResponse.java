package p_api.generalApiJsonObj;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;

public class UserResponse {
	@SerializedName("data")
	private UserData data;

	@SerializedName("support")
	private UserSupport UserSupport;

	public UserData getData() {
		return data;
	}

	public UserSupport getSupport() {
		return UserSupport;
	}

	public static UserResponse fromJson(String jsonString) {
		Gson gson = new Gson();
		return gson.fromJson(jsonString, UserResponse.class);
	}

}
