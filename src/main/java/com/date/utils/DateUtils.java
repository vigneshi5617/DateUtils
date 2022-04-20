package com.date.utils;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.regex.Pattern;

import org.apache.commons.lang3.ObjectUtils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
//import org.springframework.util.ObjectUtils;


/**
 * 
 * @author Vignesh Anand
 *
 */

public final  class DateUtils {

	private static final Logger Log = LoggerFactory.getLogger(DateUtils.class);
	
	public static Date formatDDMMYYYYfromDate(String dateString) {
	 if(ObjectUtils.isNotEmpty(dateString)) {
	LocalDate datetime =null;
	
	try {
		DateTimeFormatter FORMATTER =DateTimeFormatter.ofPattern("MM/dd/yyyy");
		
		datetime=LocalDate.parse(dateString,FORMATTER);
		
	}catch(Exception e) {
		
	}
	
	return java.util.Date.from(datetime.atStartOfDay()
			.atZone(ZoneId.systemDefault())
			.toInstant());
	
	}
	return null;
	
	}
	
	/**
	 * 
	 * UI is sending date in YYYY-MM--DD string format
	 * This method is used to convert it to MM/DD/YYYY String format
	 * @param dataString
	 * @return
	 */
	
	
	public static String formatYYYYMMDDStringToMMDDYYYYString(String dateString) {
		
		if(ObjectUtils.isNotEmpty(dateString)) {
			
			DateTimeFormatter currentFormat=getCurrentDateTimeFormatter(dateString);
			DateTimeFormatter targetFormat=DateTimeFormatter.ofPattern("MM/dd/yyyy");
			LocalDate dateTime=LocalDate.parse(dateString,currentFormat);
			
			return dateTime.format(targetFormat);
			
			
		}
		return null;
		
	}
	
	
	protected static DateTimeFormatter getCurrentDateTimeFormatter(String dateString) {
		
		String dateRegexYYYYMMDD ="((\\d{2,4})-((0[1-9])|(1[0-2]))-((0[1-9])|([1-2][0-9])|(3[0-1])))";
		
		if(Pattern.matches(dateRegexYYYYMMDD, dateString)) {
			return DateTimeFormatter.ofPattern("yyyy-MM-dd");
		}
		return DateTimeFormatter.ofPattern("MM/dd/yyyy");
	}
}
