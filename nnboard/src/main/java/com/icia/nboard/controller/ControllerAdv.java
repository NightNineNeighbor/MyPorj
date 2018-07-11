package com.icia.nboard.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ControllerAdv {
	
	@ExceptionHandler(NullPointerException.class)
	public String npC() {
		return "redirect:/";
	}

}
