package com.icia.nboard;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.Locale;
import java.util.Map;
import java.util.Optional;

import org.apache.tiles.request.ApplicationContext;
import org.apache.tiles.request.ApplicationResource;
import org.junit.Test;

public class DateTest {
	//@Test
	public void dateTest() throws ParseException{
		SimpleDateFormat transFormat = new SimpleDateFormat("yyyy-MM-dd E a hh m");
		
		Date from = new Date();
		String to = transFormat.format(from);		
		System.out.println(to);
		
		String strFrom = "2018-07-09 월 오전 09 26";	
		Date dateTo = transFormat.parse(strFrom);
		System.out.println(dateTo);
	}
	
	@Test
	public void optionalTest() {
		
	}
	
}
