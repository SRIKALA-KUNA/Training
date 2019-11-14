package com.epam.StringTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class StrTest {


	static StringManipulation str;
	@BeforeAll
	static void initialise() {
		str = new StringManipulation();
	}
	@Test
	@DisplayName(" 1char String with and without A's")
	void singleAChar() {
		assertAll(
				() -> assertEquals("",str.manipulate("A")),
				() -> assertEquals("B",str.manipulate("B"))
				);

	}
	@Test
	@DisplayName(" null String")
	void nullCharString()
	{


		assertEquals( "",str.manipulate(""));
	}
	@Test
	@DisplayName("2 char String with and without A's")
	void twoCharString()
	{


		assertAll(
				() -> assertEquals("", str.manipulate("AA")),
				() -> assertEquals("B",str.manipulate("BA")),
				() -> assertEquals("B",str.manipulate("AB")),
				() -> assertEquals( "BB",str.manipulate("BB"))
				);
	}
	
	@Test
	@DisplayName("n char String with and without A's")
	void nCharString()
	{
		assertAll(
				() -> assertEquals("BCDEG",str.manipulate("BCDEG")),
				() -> assertEquals( "BCAADEG",str.manipulate("AABCAADEG")),
				() -> assertEquals( "BCAADEG",str.manipulate("ABCAADEG")),
				() -> assertEquals( "AABCAADEG",str.manipulate("AAAABCAADEG"))
				);
	}
	


}
