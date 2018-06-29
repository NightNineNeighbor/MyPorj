package com.icia.zboard.controller;

import java.util.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.ui.*;
import org.springframework.validation.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.*;
import org.springframework.web.servlet.mvc.support.*;

import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.databind.*;

@ControllerAdvice
public class ExceptionControllerAdvice {
	@Autowired
	ObjectMapper mapper;
	
	// BoardService.read()에 Optional.get()을 사용했으므로 NPE가 발생할 수 있다
	// 이 경우 /에서 오류 alert을 띄우고 리스트 화면으로 이동
	@ExceptionHandler(NullPointerException.class)
	public String NPEHandler(NullPointerException npe, RedirectAttributes ra) {
		ra.addFlashAttribute("msg", "처리중에 문제가 발생했습니다 : " + npe.getMessage());
		return "redirect:/";
	}
	
	@ExceptionHandler(BindException.class)
	public String bindExceptionHandler(BindingResult result, Model model) {
		List<ObjectError> list =  result.getAllErrors();
		List<String> msgs = new ArrayList<String>(); 
		for(ObjectError oe : list) { 
			FieldError fe = (FieldError)oe;
			msgs.add(fe.getField() + ":" +  oe.getDefaultMessage());
		}
		try {
			model.addAttribute("msgs", mapper.writeValueAsString(msgs));
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return "system/exceptionMsgs";
	}
	
	@ExceptionHandler(IllegalArgumentException.class)
	public String illegalArgumentExceptionHandler(IllegalArgumentException iae, Model model) {
		try {
			model.addAttribute("msg", mapper.writeValueAsString(iae.getMessage()));
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return "system/exceptionMsg";
	}
	
}
