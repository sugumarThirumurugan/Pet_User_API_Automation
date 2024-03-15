package api.endpoints;
import static io.restassured.RestAssured.given;

import java.util.ResourceBundle;

import api.payloads.UserPayload;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class Endpoints2 {
	
		public static ResourceBundle getUrl() {
			
			ResourceBundle routes = ResourceBundle.getBundle("routes");
			return routes;
		}
	
	
		public static Response createUser(UserPayload payload) {
			
			String createUser = getUrl().getString("createUser");
			Response response=given()
					.accept(ContentType.JSON)
					.contentType(ContentType.JSON)
					.body(payload)
				.when()
					.post(createUser);
				return response;		
			
		}
		
		public static Response getUser(String userName) {
			String getUser = getUrl().getString("getUser");
			Response response = given() 
				.accept(ContentType.JSON)
				.contentType(ContentType.JSON)
				.pathParam("userName", userName)
				
			.when()
				.get(getUser);
			return response;
		}
		
		public static Response updateUser(UserPayload payload,String userName) {
			String updateUser = getUrl().getString("updateUser");
			Response response= given()
				.accept(ContentType.JSON)
				.contentType(ContentType.JSON)
				.pathParam("userName", userName)
				.body(payload)
			.when()
				.put(updateUser);
			return response;
		}
		
		public static Response deleteUser(String userName) {
			String deleteUser = getUrl().getString("deleteUser");
		Response response= 	given()
				.pathParam("userName", userName)
				.accept(ContentType.JSON)
				.contentType(ContentType.JSON)
			.when()
				.delete(deleteUser);
			
			return response;
		}
	
	













}
