package com.tiarebalbi.controller.advice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.servlet.ModelAndView;

import com.tiarebalbi.api.VotoRestAPI;
import com.tiarebalbi.controller.VotacaoController;
import com.tiarebalbi.validator.VotoValidator;

/**
 * @author Tiarê Balbi Bonamini
 */
@ControllerAdvice(basePackageClasses={VotoRestAPI.class, VotacaoController.class})
public class VotoAdvice {
	
	private static final String VIEW_ERROR = "error/500";
	
	@Autowired
	private VotoValidator validator;
	
	/**
	 * @param binder
	 */
	@InitBinder("voto")
	public void initBinder(WebDataBinder binder) {
		binder.setValidator(validator);
	}
	
	/**
	 * @param e {@link Exception}
	 * @return {@link ModelAndView}
	 */
	@ExceptionHandler(value=Exception.class)
	public ModelAndView handlerError(Exception e) {
		ModelAndView view = new ModelAndView(VIEW_ERROR);
		view.addObject("error", e.getMessage());
		return view;
	}

}
