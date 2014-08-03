package com.tiarebalbi.controller.advice;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author Tiarê Balbi Bonamini
 */
@ControllerAdvice(basePackages="com.tiarebalbi.api")
public class RestAPIAdvice {
	

	/**
	 * @param e 
	 * @return {@link ModelAndView}
	 */
	@ExceptionHandler(value=Exception.class)
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	public ModelAndView exceptionHandler(Exception e) {
		ModelAndView view = new ModelAndView();
		view.addObject("message", e.getMessage());
		return view;
	}
}
