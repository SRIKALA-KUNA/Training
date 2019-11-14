package com.epam.engx.cleancode.naming.task2;

import java.util.Arrays;
import java.util.Date;

public class User {

	private Date dateOfBirth;

	private String name;

	private boolean admin;

	private User[] subordinateArray;

	private int iR;

	public User(String name) {
		super();
		this.name = name;
	}

	@Override
	public String toString() {
		return "User [dateOfBirth=" + dateOfBirth + ", stringName=" + name + ", booleanAdmin=" + admin + ", subordinateArray="
				+ Arrays.toString(subordinateArray) + ", iRating=" + iR + "]";
	}

}
