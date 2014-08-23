package com.tiarebalbi.editor;

import java.beans.PropertyEditorSupport;

import com.tiarebalbi.entity.Filme;
import com.tiarebalbi.service.FilmeService;

/**
 * 
 * Class responsável por fazer a conversão da String enviada na requisição para
 * um objeto a partir da informação enviada.
 * 
 * @author Tiarê Balbi Bonamini
 */
public class CustomFilmeEditor extends PropertyEditorSupport {
	private final FilmeService service;
	
	/**
	 * @param service
	 */
	public CustomFilmeEditor(FilmeService service) {
		this.service = service;
	}
	
	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		Long id = new Long(text);
		Filme filme = this.service.buscarRegistro(id);
		setValue(filme);
	}

}
