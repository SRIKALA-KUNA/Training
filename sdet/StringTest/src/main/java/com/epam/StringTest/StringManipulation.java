package com.epam.StringTest;

public class StringManipulation {

	public String manipulate(String string) {
		int length = string.length();
		if(length > 2)
			return string.substring(0,2).replace("A","")+string.substring(2,length);
		else
			return string.replace("A","");
		
			
	}
	

}
