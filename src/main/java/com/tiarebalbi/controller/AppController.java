package com.tiarebalbi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Controller para exibição dos filmes e permitir que o usuário possa votar no filme desejado.
 * 
 * @author Tiarê Balbi Bonamini
 */
@Controller
public class AppController {
	
	
	private static final String VIEW_INDEX = "app/index";

	/**
	 * @return {@link ModelAndView}
	 */
	@RequestMapping(value={"", "/"}, method=RequestMethod.GET)
	public ModelAndView index() {
		ModelAndView view = new ModelAndView(VIEW_INDEX);
		return view;
	}
	
}