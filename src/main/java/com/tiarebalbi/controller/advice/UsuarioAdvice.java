package com.tiarebalbi.controller.advice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.InitBinder;

import com.tiarebalbi.api.UsuarioRestAPI;
import com.tiarebalbi.validator.UsuarioValidator;

/**
 * @author Tiarê Balbi Bonamini
 */
@ControllerAdvice(basePackageClasses={UsuarioRestAPI.class})
public class UsuarioAdvice {
	
	@Autowired
	private UsuarioValidator validator;
	
	/**
	 * @param binder
	 */
	@InitBinder("usuario")
	public void initBinder(WebDataBinder binder) {
		binder.setValidator(validator);
	}

}
