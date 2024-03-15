package api.utilities;

import org.testng.annotations.DataProvider;

public class DataProviders {
	
	@DataProvider(name = "ExcelData")
	public String [][]getAllData()throws Exception{
		Utilities utilities = new Utilities();
		int row = utilities.getRow("sheet1");
		int cell = utilities.getCell("sheet1");
		String data[][]=new String[row][cell];
		
		for(int i=1; i<=row; i++) {
			for(int j=0; j<cell; j++) {
				data[i-1][j] = utilities.getData("sheet1",i,j);
			}}
		return data;
	}
	
	@DataProvider(name = "idProvider")
	public String[]getUserName()throws Exception{
		Utilities utilities = new Utilities();
		int row = utilities.getRow("sheet1");
		String data[]=new String[row];
		for (int i = 1; i <=row; i++) {
			data[i-1] = utilities.getData("sheet1", i, 1);
		}
		return data;
	}
	

}
