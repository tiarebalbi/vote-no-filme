package com.tiarebalbi.api;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.tiarebalbi.entity.Chat;
import com.tiarebalbi.entity.QChat;
import com.tiarebalbi.entity.QUsuario;
import com.tiarebalbi.entity.Usuario;
import com.tiarebalbi.service.ChatService;
import com.tiarebalbi.service.UsuarioService;

/**
 * @author Tiarê Balbi Bonamini
 */
@RestController
@RequestMapping(value="/api/chat", produces="application/json")
public class ChatRestAPI {
	
	private static final int TOTAL_HISTORICO_MENSAGEM = 20;
	
	@Autowired
	private ChatService service;
	
	@Autowired
	private UsuarioService usuarioService;
	
	/**
	 * @return {@link ModelAndView}
	 */
	@RequestMapping(value="/listar", method=RequestMethod.GET)
	public ModelAndView listar() {
		ModelAndView view = new ModelAndView();
		Page<Chat> registros = this.service.buscarTodos(QChat.chat.usuario.isNotNull(), new PageRequest(0, TOTAL_HISTORICO_MENSAGEM, new Sort(Sort.Direction.DESC, "horario")));
		view.addObject("data", registros.getContent());
		return view;
	}
	
	/**
	 * @param mensagem
	 * @param bind
	 * @param request
	 * @return {@link ModelAndView}
	 */
	@RequestMapping(value="/enviar", method=RequestMethod.POST)
	public ModelAndView salvar(@ModelAttribute("mensagem") @Valid Chat mensagem, BindingResult bind, HttpServletRequest request) {
		ModelAndView view = new ModelAndView();
		
		if(bind.hasErrors()) {
			view.addObject("message", bind.getGlobalError().getDefaultMessage());
			view.addObject("status", "error");
			return view;
		}

		try {
			
			Usuario usuario = this.usuarioService.buscarRegistro(QUsuario.usuario.sessoes.contains(request.getSession().getId()));
			mensagem.setUsuario(usuario);
			
			this.service.salvar(mensagem);
			view.addObject("message", "Mensagem enviada!");
			view.addObject("status", "success");
			
		} catch(RuntimeException e) {
			view.addObject("message", e.getMessage());
			view.addObject("status", "error");
		}		
		return view;
	}

}
