package com.date.utils;

import java.util.Date;
import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DateutilsApplication {

	private static final Logger log = LoggerFactory.getLogger(DateutilsApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(DateutilsApplication.class, args);
		
		
		String date;
		date =new String("12/23/2021");
		log.info("date is ->{}",DateUtils.formatDDMMYYYYFromDate(date));
		date=new String("2021-11-29");
		
		log.info("date is ->{}",DateUtils.formatYYYYMMDDStringToMMDDYYYYString(date));
	
		date = new String("04/09/2022");
		
		log.info("date is ->{}",DateUtils.formatStringYYYYMMDDTOMMDDYYYYDate(date));
		
		
		Date d = new Date();
		log.info("the date is ->{}",d);
		log.info("date is ->{}",DateUtils.formatDateWithCDTTimestamp(d));
		
		
		//Very useful method down please use this 
		log.info("date is ->{}",DateUtils.formatDateAsMMDDYYYY(d));
		
		
		
		log.info("date is ->{}",DateUtils.formatDateAsTimeStamp(d));
		
		
		date =new String("03/06/2007 13:44 PM");
		
		log.info("date is ->{}",DateUtils.formatMMDDYYYhhmmaaFromDateTimeStr(date));
		
		
		
		
		
	}

	
	
	
}
