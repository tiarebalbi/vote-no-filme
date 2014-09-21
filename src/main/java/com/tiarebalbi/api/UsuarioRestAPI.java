package com.tiarebalbi.api;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import com.tiarebalbi.entity.QUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
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
	 * @param usuario {@link Usuario}
	 * @param bind {@link BindingResult}
	 * @param request {@link HttpServletRequest}
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

    /**
     * Método para consultar os dados do usuário logcado caso já tenha sido cadastrado.
     *
     * @param request {@link HttpServletRequest}
     * @return {@link ModelAndView}
     */
    @RequestMapping(method=RequestMethod.GET)
    public ModelAndView usuarioLogado(HttpServletRequest request) {
        ModelAndView view = new ModelAndView();
        String sessionId = request.getSession().getId();
        Usuario usuario = this.service.buscarRegistro(QUsuario.usuario.sessoes.contains(sessionId));
        view.addObject("usuario", usuario);
        view.addObject("session", sessionId);
        return view;
    }

    /**
     * Método para consultar informações do usuário pelo nome
     *
     * @param sessionId {@link String}
     * @param request {@link HttpServletRequest}
     * @return {@link ModelAndView}
     */
    @RequestMapping(value="/{sessionId}",method=RequestMethod.GET)
    public ModelAndView usuarioPorSessao(@PathVariable("sessionId") String sessionId, HttpServletRequest request) {
        ModelAndView view = new ModelAndView();

        Usuario usuario = this.service.buscarRegistro(QUsuario.usuario.sessoes.contains(sessionId));
        view.addObject("usuario", usuario);
        view.addObject("session", sessionId);
        return view;
    }
	
}