package com.tiarebalbi.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.tiarebalbi.entity.Voto;

/**
 * @author Tiarê Balbi Bonamini
 */
@Component
public class VotoValidator implements Validator {

	@Override
	public boolean supports(Class<?> arg0) {
		return Voto.class.equals(arg0);
	}

	@Override
	public void validate(Object objeto, Errors erros) {
		ValidationUtils.rejectIfEmpty(erros, "filme", "validacao.voto.filme.empty");
	}
	
}
