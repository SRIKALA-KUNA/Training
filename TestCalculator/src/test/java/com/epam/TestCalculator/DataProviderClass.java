package com.epam.TestCalculator;



import org.testng.annotations.DataProvider;


public class DataProviderClass {
	@DataProvider(name = "sumDataLong" )
	public static Object[][] sumLong() {

		String path = "C:\\Users\\Srikala_Kuna\\eclipse-workspace\\TestCalculator\\excel\\sumDataLong.xlsx";
		String sheetName = "Sheet1";
		ExcelSumDataProvider data = new ExcelSumDataProvider();
		return data.sumData(path,sheetName);
	}
	@DataProvider(name = "sumDataDouble")
	public static Object[][] sumDouble() {
		Object[][] object = new Object[][] {
			{2.0,2.0,4.0},
			{6.0,0.0,6.0},
			{0,0,0},
			{-2.3,3.5,1.2000000000000002},
			{-4.4,-3.3,-7.7},
			{3.7,6.5,5.43453434},
			{8.144,0.414,4.1313},
			{-2.243434,4.14244,-2.3434},
			{0.24244,0.34241,1.132424},
			{-2.132,-4.224,6.23424}
		};
		return object;
	}

	@DataProvider(name = "subDataLong")
	public static Object[][] subLong() {
		
		CSVUtils csv = new CSVUtils();
		return csv.subData();

	}

	@DataProvider(name = "subDataDouble")
	public static Object[][] subDouble() {
		Object[][] object=new Object[][] {
			{2.3645,3.4654,-1.1008999999999998},
			{3.4654,2.3645,1.1008999999999998}, 
			{0,0,0}, 
			{-2.3645,3.4654,-5.8299}, 
			{-2.3645,-3.4654,1.1008999999999998},
			{3.121231,6.2313,5.233},
			{8.2323,0,4.213},
			{-2.2323,4.2324,-2.324},
			{0,0,1.234},
			{-2.1231,-4.2422421,6.244}};
			return object;
	}

	@DataProvider(name = "multDataLong")
	public static Object[][] multLong() {
		Object[][] object = new Object[][] {
			{2,4,8},
			{6,0,0}, 
			{0,0,0}, 
			{-2,3,-6}, 
			{-4,-3,12},
			{3,6,5},
			{8,0,4},
			{-2,4,-2},
			{0,0,1},
			{-2,-4,6}
		};
		return object;
	}

	@DataProvider(name = "multDataDouble")
	public static Object[][] multDouble() {
		Object[][] object = new Object[][] {
			{2.4564,4.9742,12.0},
			{6.1244,0,0}, 
			{0,0,0},
			{-2.4564,4.9742,-13.0}, 
			{-2.4564,-4.9742,12.0},
			{3.1313,6.131,-5.1313},
			{8.313,0,41313.131},
			{-2.313,4,-2.313},
			{0,0,131313.313},
			{-2,-4313,61313.1313}
		};
		return object;
	}

	@DataProvider(name = "divDataLong")
	public static Object[][] divLong() {
		Object[][] object = new Object[][] {
			{4,2,2},
			{-4 ,2,2}, 
			{-12,-3,4},
			{3,6,5},
			{-1225131314,3123,-392293},
			{-2,4,-2},
			{0,6,123},
			{-2,-4,2313}};
			return object;
	}

	@DataProvider(name="divDataBy0")
	public static Object[][] divBy0(){
		Object[][] object = new Object[][] {
			{0,0,0},
			{8,0,4},
		};
		return object;
	}

	@DataProvider(name = "divDataDouble")
	public static Object[][] divDouble() {
		Object[][] object = new Object[][] {
			{4.1213,2.1313,1.9337024351334866},
			{-12251313142424.1313,3.212,-3.8142319870560806E12},
			{-4.133 ,2.1313,-1.9391920424154272}, 
			{-12.131,-3.313,3.6616359794747964},
			{3.313,6.1313,0.5403421786570548},
			{8131.13,0,4},
			{-2.131,4.1313,-2},
			{1212,-11313,1},
			{-21212,-4.212,6},
			{0,212,12}};
			return object;
	}

	@DataProvider(name = "sqrtData")
	public static Object[][] sqrtDouble() {
		Object[][] object = new Object[][] {
			{4.1213,2.030098519776811},
			{-121313,348.300157909812}, 
			{0,0},
			{1225.00,35.0},
			{25,5},
			{-1225.00d,351.0},
			{8131.224,4},
			{-1225,-35},
			{1212,-11313},
			{12134354646456.12131313143,121311313331313131313.31}

		};
		return object;
	}



	@DataProvider(name = "powDataDouble")
	public static Object[][] powDouble() {
		Object[][] object = new Object[][] {
			{-1225,2.212,1500625.0},
			{1225,2.212,1500625.0}, 
			{-1225,-3.212,4.440743054270217E-13},
			{-1225,3,-1.838265625E9},
			{1225.00,0,1},
			{0,0,0},
			{-1225.00,-13,35.0},
			{8131.224,-13213,4},
			{1212,121,121313},
			{-1212,121,-11313},

		};
		return object;
	}





}