package com.icia.nboard;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;

public class DateTest {
	@Test
	public void dateTest() throws ParseException{
		SimpleDateFormat transFormat = new SimpleDateFormat("yyyy-MM-dd E a hh m");
		
		Date from = new Date();
		String to = transFormat.format(from);		
		System.out.println(to);
		
		String strFrom = "2018-07-09 월 오전 09 26";	
		Date dateTo = transFormat.parse(strFrom);
		System.out.println(dateTo);
		
		

	}
	
}
