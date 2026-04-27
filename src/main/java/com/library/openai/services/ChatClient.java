package com.library.openai.services;

public interface ChatClient {
	/**
	 * Adiciona el mensaje del System
	 * @param message
	 */
	void addSystem(String message);
	
	/***
	 * Devuelve la respuesta.
	 * @param message
	 * @return
	 */
	String chat(String message); 
}
