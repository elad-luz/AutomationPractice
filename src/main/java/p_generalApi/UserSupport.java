package p_generalApi;

import com.google.gson.annotations.SerializedName;

class UserSupport {
	@SerializedName("url")
	private String url;

	@SerializedName("text")
	private String text;

	public String getUrl() {
		return url;
	}

	public String getText() {
		return text;
	}
}