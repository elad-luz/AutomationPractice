package p_api.generalApiJsonObj;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

public class UserClient { // First stage - send a GET using URL to Make a Webz API request -and- Print the JSON response returned

	// URL sent by get
	private static String API_URL = "https://reqres.in/api/users/2";

	public static void main(String[] args) throws JsonMappingException, JsonProcessingException {
		// Print the URL
		System.out.println("Testing "+ API_URL);
		System.out.println("\n=====================================\nretrieved JSON:\n");		
		// Get the JSON response from API as a String
		String jsonResponseFromApi = makeApiRequest();
		// Print the JSON response
		System.out.println(jsonResponseFromApi);
		System.out.println("\n=====================================\n");
		// parse & convert jsonResponseFromApi into a Java Object
		UserResponse userResponse = UserResponse.fromJson(jsonResponseFromApi);

		// Access the info in the Java object
		UserData userData = userResponse.getData();
		System.out.println("ID: " + userData.getId());
		System.out.println("Email: " + userData.getEmail());
		System.out.println("First Name: " + userData.getFirstName());
		System.out.println("Last Name: " + userData.getLastName());
		System.out.println("Avatar: " + userData.getAvatar());

		UserSupport userSupport = userResponse.getSupport();
		System.out.println("Support URL: " + userSupport.getUrl());
		System.out.println("Support Text: " + userSupport.getText());

/*		
		// parse & convert jsonResponseFromApi into a Java Object
		Gson gson = new Gson(); // Create the needed Gson object
    	WebzResponseTBD webzResponseTBD = gson.fromJson(jsonResponseFromApi, WebzResponseTBD.class);	
        // Print the Java object.
        System.out.println(webzResponseTBD);
        System.out.println("\n=====================================\n");
        // Access the information in the Java object -> Print the title of the first news article
		// WebzResponse webzResponse = new WebzResponse(null, null, null);
        if (webzResponseTBD != null) {
            System.out.println("For Example -> Title: " + webzResponseTBD);
            System.out.println("\n=====================================\n");
        }else {
            System.out.println("Failed to receive any response object");
            System.out.println("\n=====================================\n");
        }
*/
    }

	// Get the JSON response from the API request (retrieved as String)
	private static String makeApiRequest() {
		try {
			HttpClient httpClient = HttpClientBuilder.create().build();
			HttpGet request = new HttpGet(API_URL);
			//request.setHeader("Accept", "application/json");

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
