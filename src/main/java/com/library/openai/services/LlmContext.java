package com.library.openai.services;

import java.util.List;

import com.library.openai.dtos.ChatMessage;

public interface LlmContext {
	
	void add(ChatMessage message);
	
	void addRange(List<ChatMessage> messages);
	
	List<ChatMessage> getMessages();
}
