package p_api.generalApiJsonObj;

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