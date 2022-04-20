package com.date.utils;

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
		log.info("date is ->{}",DateUtils.formatDDMMYYYYfromDate(date));
		date=new String("2021-11-29");
		
		log.info("date is ->{}",DateUtils.formatYYYYMMDDStringToMMDDYYYYString(date));
		
	}

	
	
	
}
