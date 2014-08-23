package com.tiarebalbi.api;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.tiarebalbi.entity.Usuario;
import com.tiarebalbi.service.UsuarioService;

/**
 * @author Tiarê Balbi Bonamini
 */
@RestController
@RequestMapping(value="/api/usuario/**", produces="application/json", consumes="application/json")
public class UsuarioRestAPI {
	
	@Autowired
	private UsuarioService service;

	/**
	 * @param usuario
	 * @param bind
	 * @param request
	 * @return {@link ModelAndView}
	 */
	@RequestMapping(method=RequestMethod.POST)
	public ModelAndView salvar(@RequestBody @Valid Usuario usuario, BindingResult bind, HttpServletRequest request) {
		ModelAndView view = new ModelAndView();
		
		if(bind.hasErrors()) {
			view.addObject("message", bind.getGlobalError().getDefaultMessage());
			view.addObject("status", "error");
			return view;
		}

		try {
			// Relaciona o ID da sessão com o usuário
			if(!usuario.getSessoes().contains(request.getSession().getId())) {
				usuario.addSessao(request.getSession().getId());
			}
			
			this.service.salvar(usuario);
			view.addObject("message", "Usuário Registrado com Sucesso!!!");
			view.addObject("status", "success");
			
		} catch(RuntimeException e) {
			view.addObject("message", e.getMessage());
			view.addObject("status", "error");
		}		
		return view;
	}
	
}