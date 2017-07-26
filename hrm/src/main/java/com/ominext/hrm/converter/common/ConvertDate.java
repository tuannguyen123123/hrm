package com.ominext.hrm.converter.common;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ConvertDate {

	public static Date convertStringToDate(String typeDate, String date) {
		Date dateFormat = null;
		SimpleDateFormat formatter = new SimpleDateFormat(typeDate);
		try {
			dateFormat = formatter.parse(date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dateFormat;

	}

}
