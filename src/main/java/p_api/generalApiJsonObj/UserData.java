package p_api.generalApiJsonObj;

import com.google.gson.annotations.SerializedName;

class UserData {
	@SerializedName("id")
	private int id;

	@SerializedName("email")
	private String email;

	@SerializedName("first_name")
	private String firstName;

	@SerializedName("last_name")
	private String lastName;

	@SerializedName("avatar")
	private String avatar;

	public int getId() {
		return id;
	}

	public String getEmail() {
		return email;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getAvatar() {
		return avatar;
	}
}
