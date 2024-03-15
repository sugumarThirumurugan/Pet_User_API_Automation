package api.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import api.endpoints.Endpoints2;
import api.payloads.UserPayload;
import io.restassured.response.Response;

public class DataDrivenTest2 {
	UserPayload payload;
	
	@Test(dataProvider = "ExcelData", priority=1,dataProviderClass = api.utilities.DataProviders.class)
	public void testPostUser(String[] data) {
		
		payload = new UserPayload();
		payload.setId(Integer.parseInt(data[0]));
		payload.setUsername(data[1]);
		payload.setFirstName(data[2]);
		payload.setLastName(data[3]);
		payload.setEmail(data[4]);
		payload.setPassword(data[5]);
		payload.setPhone(data[6]);	
			
		Response response=Endpoints2.createUser(payload);
		Assert.assertEquals(response.getStatusCode(),200);
		response.then().log().body();

	}
	
	@Test(dataProvider = "idProvider", priority=2,dataProviderClass = api.utilities.DataProviders.class)
	public void testDeleteUser(String userName[]) throws Exception{
		Response response = Endpoints2.deleteUser(userName[0]);
		Assert.assertEquals(response.getStatusCode(),200);
		response.then().log().body();
	}
	
	
	

}














