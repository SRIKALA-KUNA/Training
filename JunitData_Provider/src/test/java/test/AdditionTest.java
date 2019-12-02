package test;



import org.assertj.core.api.SoftAssertions;
import org.junit.Test;
import org.junit.runner.RunWith;

import addition.Addition;
import custom.annotations.Data;
import custom.annotations.DataInjection;
@RunWith(CustomRunner.class)
public class AdditionTest {



	@DataInjection(dataProvider ="dataForSum")
	@Test
	public void testAdd(int input1,int input2,int expectedResult) {

		int actual;
		Addition add = new Addition();			
		actual =add.add(input1, input2);
		System.out.println(actual+"  "+expectedResult);
		SoftAssertions softAssertions = new SoftAssertions();
		softAssertions.assertThat(actual).isEqualTo(expectedResult);
		//softAssertions.assertAll();
	}
	@DataInjection(dataProvider ="negativeData")
	@Test
	public void testNegativeAdd(int input1,int input2,int expectedResult) {

		int actual;
		Addition add = new Addition();			
		actual =add.add(input1, input2);
		System.out.println(actual+"  "+expectedResult);
		SoftAssertions softAssertions = new SoftAssertions();
		softAssertions.assertThat(actual).isEqualTo(expectedResult);
		//softAssertions.assertAll();
	}
	@Data(name = "dataForSum")
	public Object[][] additionData()
	{

		Object [][] obj = new Object[][] {
			{2,2,4},
			{0,2,2},
			{4,6,10},
			{-4,3,-1},
			{2,2,0},
			{-3,4,7}
		};
		return obj;

	}
	@Data(name = "negativeData")
	public Object[][] negativeAdditionData()
	{
		Object [][] obj = new Object[][] {
			{2,2,0},
			{-3,4,7}
		};
		 return obj;
	}

}
