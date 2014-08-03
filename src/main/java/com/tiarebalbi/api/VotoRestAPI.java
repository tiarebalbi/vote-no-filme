package com.tiarebalbi.api;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.tiarebalbi.entity.Usuario;
import com.tiarebalbi.entity.Voto;
import com.tiarebalbi.service.RankingService;
import com.tiarebalbi.service.UsuarioService;
import com.tiarebalbi.service.VotoService;

/**
 * @author Tiarê Balbi Bonamini
 */
@RestController
@RequestMapping(value="/api/voto",produces="application/json")
public class VotoRestAPI {
	
	@Autowired
	private VotoService service;
	
	@Autowired
	private RankingService ranking;
	
	@Autowired
	private UsuarioService usuarioService;
	
	/**
	 * Método responsável em salvar um novo
	 * @param voto 
	 * @param bind 
	 * @param request 
	 * 
	 * URL: [POST, PUT] -> /api/voto/salvar 
	 * 
	 * @return {@link ModelAndView}
	 */
	@RequestMapping(value="/salvar", method={RequestMethod.POST,RequestMethod.PUT})
	public ModelAndView salvarVoto(@ModelAttribute("voto") @Valid Voto voto, BindingResult bind, HttpServletRequest request) {
		ModelAndView view = new ModelAndView();
		
		if(bind.hasErrors()) {
			view.addObject("message", bind.getGlobalError().getDefaultMessage());
			view.addObject("status", "error");
			return view;
		}

		try {
			// Define a ID da sessão para o voto
			voto.setSession(request.getSession().getId());
			
			this.service.salvar(voto);
			view.addObject("message", "Voto Registrado com Sucesso!!!");
			view.addObject("status", "success");
			
		} catch(RuntimeException e) {
			view.addObject("message", e.getMessage());
			view.addObject("status", "error");
		}
		
		return view;
	}
	
	/**
	 * Método de Acesso ao Rank geral de todos os filmes do sistema
	 * 
	 * URL: [GET] -> /api/voto/ranking/geral
	 * 
	 * @return {@link ModelAndView}
	 */
	@RequestMapping(value="/ranking/geral", method=RequestMethod.GET)
	public ModelAndView rankingGeral() {
		ModelAndView view = new ModelAndView();
		view.addObject("data", this.ranking.buscarRankGeral());
		return view;
	}

	/**
	 * Método de Acesso ao Rank geral de todos os filmes do sistema
	 * 
	 * URL: [GET] -> /api/voto/ranking/usuario/{idUsuario}
	 * 
	 * @param idUsuario {@link Long} 
	 *  
	 * @return {@link ModelAndView}
	 */
	@RequestMapping(value="/ranking/usuario/{idUsuario}", method=RequestMethod.GET)
	public ModelAndView rankingUsuario(@PathVariable("idUsuario") Long idUsuario) {
		ModelAndView view = new ModelAndView();
		
		Usuario usuario = this.usuarioService.buscarRegistro(idUsuario);
		view.addObject("data", this.ranking.buscarRank(usuario));
		
		return view;
	}
}
