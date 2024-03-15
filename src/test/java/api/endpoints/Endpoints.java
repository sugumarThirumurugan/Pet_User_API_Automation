package api.endpoints;
import static io.restassured.RestAssured.given;
import api.payloads.UserPayload;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class Endpoints {
	
		public static Response createUser(UserPayload payload) {
			Response response=given()
					.accept(ContentType.JSON)
					.contentType(ContentType.JSON)
					.body(payload)
				.when()
					.post(Routes.createUser);
				return response;		
			
		}
		
		public static Response getUser(String userName) {
			Response response = given() 
				.accept(ContentType.JSON)
				.contentType(ContentType.JSON)
				.pathParam("id", userName)
				
			.when()
				.get(Routes.getUser);
			return response;
		}
		
		public static Response updateUser(UserPayload payload,String userName) {
			
			Response response= given()
				.accept(ContentType.JSON)
				.contentType(ContentType.JSON)
				.pathParam("userName", userName)
				.body(payload)
			.when()
				.put(Routes.updateUser);
			return response;
		}
		
		public static Response deleteUser(String userName) {
		Response response= 	given()
				.pathParam("userName", userName)
				.accept(ContentType.JSON)
				.contentType(ContentType.JSON)
			.when()
				.delete(Routes.deleteUser);
			
			return response;
		}
	
	













}
