package com.library.openai.dtos;

import java.io.Serializable;
import java.util.Optional;

import lombok.AllArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@Setter
public class ChatMessageImpl implements ChatMessage, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String content;
	private String role;

	@Override
	public String getRole() {
		return role;
	}

	@Override
	public Optional<String> getContent() {
		return content == null ? Optional.empty() : Optional.of(content);
	}

}
