package com.icia.zboard.util;

import java.beans.*;
import java.text.*;
import java.util.*;

public class DateCustomEditor extends PropertyEditorSupport {
	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		Date date = null;
		try {
			date = new SimpleDateFormat("yyyy-MM-dd").parse(text);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		setValue(date);
	}
}