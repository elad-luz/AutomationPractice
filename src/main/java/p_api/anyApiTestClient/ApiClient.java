package p_api.anyApiTestClient;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

public class ApiClient { // First stage - send a GET using URL to Make a Webz API request -and- Print the JSON response returned
	// constructing URL
	private static String API_BaseURL = "https://reqres.in";
	private static String URL_API1stLeg = "api";
	private static String URL_API2edLeg = "users";
	private static String URL_API3edLeg = "2";
	// URL sent by get request
	private static String API_URL = API_BaseURL + "/" + URL_API1stLeg  + "/" + URL_API2edLeg + "/" + URL_API3edLeg;

	public static void main(String[] args) throws JsonMappingException, JsonProcessingException {
		// Print the URL
		System.out.println("> Testing  " + API_URL + "\n> Response:\n");
		// Get the JSON response from API as a String
		String jsonResponseFromApi = makeApiRequest();
		// Print the JSON response
		System.out.println(jsonResponseFromApi);
	}

	// Get the JSON response from the API request (retrieved as String)
	private static String makeApiRequest() {
		try {
			HttpClient httpClient = HttpClientBuilder.create().build();
			HttpGet request = new HttpGet(API_URL);
			// request.setHeader("Accept", "application/json");

			HttpResponse response = httpClient.execute(request);
			HttpEntity entity = response.getEntity();

			if (entity != null) {
				return EntityUtils.toString(entity);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
}
