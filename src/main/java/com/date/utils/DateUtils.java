package com.date.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
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
	
	public static Date formatDDMMYYYYFromDate(String dateString) {
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
	
	
	
	
	public static Date formatStringYYYYMMDDTOMMDDYYYYDate(String dateString) {
		
		String formattedDateString = formatYYYYMMDDStringToMMDDYYYYString(dateString);
		
		final Date date= formatDDMMYYYYFromDate(formattedDateString);
		
		return date;
		
		
	}
	
	public static String formatDateWithCDTTimestamp(Date dateString) {
		
		if(ObjectUtils.isNotEmpty(dateString)) {
			String dateTime=null;
			
			ZonedDateTime zonedDateTime= null;
			
			try {
				
				DateTimeFormatter dateFormat =DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss z");
				
				Instant epochTime=Instant.ofEpochMilli(dateString.getTime());
				zonedDateTime=ZonedDateTime.ofInstant(epochTime,ZoneId.of("America/Chicago") );
				dateTime=zonedDateTime.format(dateFormat);
				
			}catch (Exception e) {
				e.printStackTrace();
			}
			
			return dateTime;
			
			
		}
		return null;
	}
	
	/**
	 * 
	 * @param strDate
	 * @return
	 */
	
	
	public static String formatDateAsMMDDYYYY(Date strDate) {
		String dateStr="";
		
		if(ObjectUtils.isNotEmpty(strDate)) {
			SimpleDateFormat  newFormat= new SimpleDateFormat("MM/dd/yyyy");
			
			dateStr =newFormat.format(strDate);
			
			
		}
		
		
		return dateStr;
		
	}
	
	/**
	 * 
	 * @param dateString
	 * @return
	 */
	
	
	public static String formatDateAsTimeStamp(Date dateString) {
		
		if(ObjectUtils.isNotEmpty(dateString)) {
			String outputString = "";
			try {
				
				// Format date into output format
				
				DateFormat outputFormat=new SimpleDateFormat("MM/dd/yyyy HH:mm:ss.S");
				
				outputString = outputFormat.format(dateString);
			} catch(Exception e) {
				e.printStackTrace();
			}
			
			return outputString;
			
		}
		
		return "";
		
	}
	
	
	/**
	 * 
	 * @param dateString
	 * @return
	 */
	
	public static String formatMMDDYYYhhmmaaFromDateTime(Date dateString) {
		
		if(ObjectUtils.isNotEmpty(dateString)) {
			
			String outputString ="";
			
			try {
				
				//Format date into output format
				
				DateFormat outputFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm a");
				outputString =outputFormat.format(dateString);
				
			}catch(Exception e) {
				e.printStackTrace();
			}
			
			return outputString;
		}
		return "";
	}
	
	
	/**
	 * 
	 * @param dateString
	 * @return
	 */
	
	public static Date formatMMDDYYYhhmmaaFromDateTimeStr(String dateString) {
		
		if(ObjectUtils.isNotEmpty(dateString)) {
			Date pendingRollingDT=null;
			
			try {
				
				SimpleDateFormat formatter = new SimpleDateFormat ("MM/dd/yyyy HH:mm a");
				pendingRollingDT=formatter.parse(dateString);
				
			}catch(Exception e) {
				Log.error("Conversion failed of start or end date to String");
				e.printStackTrace();
				
				
			}
			
			return pendingRollingDT;
		}
			
		return null;
		
	}
	
	
	
}
