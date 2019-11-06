package com.epam.engx.cleancode.functions.task5;

import java.util.Calendar;
import java.util.Date;

public class DateUtil {

	public Date changeToMidnight(Date date, boolean up) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		addDel(up, calendar);
		setHour(calendar);
		return calendar.getTime();
	}

	public void addDel(boolean up, Calendar calendar) {
		calendar.add(Calendar.DATE, up ? 1 : -1);
	}

	public void setHour(Calendar calendar) {
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MILLISECOND, 0);
	}

}
