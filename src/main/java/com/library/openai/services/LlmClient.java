package com.library.openai.services;

import com.library.openai.dtos.ChatMessage;

public interface LlmClient {
	
	String chat(LlmContext context);

	ChatMessage createSystemMessage(String content);

	ChatMessage createUserMessage(String content);

	ChatMessage createAssistantMessage(String content);
}
