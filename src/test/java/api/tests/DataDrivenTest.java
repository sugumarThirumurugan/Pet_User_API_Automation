package api.tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import api.endpoints.Endpoints;
import api.payloads.UserPayload;
import io.restassured.response.Response;

public class DataDrivenTest {
	UserPayload payload;
	public Logger logger;
	
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
		
		logger= LogManager.getLogger(this.getClass());
		logger.debug("debugging.....");
		logger.info("Creating User");
		Response response=Endpoints.createUser(payload);
		Assert.assertEquals(response.getStatusCode(),200);
		logger.info("User is Created");
	}
	
	@Test(dataProvider = "idProvider", priority=2,dataProviderClass = api.utilities.DataProviders.class)
	public void testDeleteUser(String userName[]) throws Exception{
		logger.info("Deleting User");
		Response response = Endpoints.deleteUser(userName[0]);
		Assert.assertEquals(response.getStatusCode(),200);
		logger.info("User is Deleted");
	}
	
	
	

}














