package com.tiarebalbi.controller.advice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import com.tiarebalbi.api.VotoRestAPI;
import com.tiarebalbi.editor.CustomFilmeEditor;
import com.tiarebalbi.entity.Filme;
import com.tiarebalbi.service.FilmeService;
import com.tiarebalbi.validator.VotoValidator;

/**
 * @author Tiarê Balbi Bonamini
 */
@ControllerAdvice(basePackageClasses={VotoRestAPI.class})
public class VotoAdvice {
	
	@Autowired
	private VotoValidator validator;
	
	@Autowired
	private FilmeService service;
	
	/**
	 * @param binder
	 */
	@InitBinder("voto")
	public void initBinder(WebDataBinder binder) {
		binder.setValidator(validator);
		binder.registerCustomEditor(Filme.class, new CustomFilmeEditor(service));
	}
	
	/**
	 * @param e {@link Exception}
	 * @return {@link ModelAndView}
	 */
	@ExceptionHandler(value=Exception.class)
	@ResponseStatus(value=HttpStatus.INTERNAL_SERVER_ERROR)
	public ModelAndView handlerError(Exception e) {
		ModelAndView view = new ModelAndView();
		view.addObject("error", e.getMessage());
		return view;
	}

}
