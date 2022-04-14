package com.zensar.db;

import java.sql.Date;
import java.time.LocalDate;

public class DateConversion {

	public static Date convertToSQLDate(LocalDate localdate){
		Date date = Date.valueOf(localdate);
		return date;
	}
	public static LocalDate convertToLocalDate(Date date){
		LocalDate localdate = date.toLocalDate();
		return localdate;
	}
	
}
