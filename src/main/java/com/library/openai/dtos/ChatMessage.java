package com.library.openai.dtos;

import java.util.Optional;

public interface ChatMessage {

	/**
	 * Retorna el Rol
	 * @return
	 */
	String getRole();
	
	/**
	 * Retorna el contenido del mensaje
	 * @return
	 */
	
	Optional<String> getContent();
}
