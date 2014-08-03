package com.tiarebalbi.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.tiarebalbi.entity.Usuario;

/**
 * @author Tiarê Balbi Bonamini
 */
@Component
public class UsuarioValidator implements Validator {

	@Override
	public boolean supports(Class<?> arg0) {
		return Usuario.class.equals(arg0);
	}

	@Override
	public void validate(Object objeto, Errors erros) {
		ValidationUtils.rejectIfEmpty(erros, "nome", "validacao.usuario.nome.empty");
		ValidationUtils.rejectIfEmpty(erros, "email", "validacao.usuario.email.empty");
	}
	
}