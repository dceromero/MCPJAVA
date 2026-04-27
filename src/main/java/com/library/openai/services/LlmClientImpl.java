package com.library.openai.services;

import org.springframework.stereotype.Service;

import com.library.openai.dtos.ChatMessage;
import com.library.openai.enums.ChatRole;
import com.library.openai.factories.OpenAIFactory;
import com.library.openai.handles.ResponseHandle;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class LlmClientImpl implements LlmClient {

	private final ResponseHandle responseHandle;
	@Override
	public String chat(LlmContext context) {
		return responseHandle.getResponse(context);
	}

	@Override
	public ChatMessage createSystemMessage(String content) {
		return OpenAIFactory.createMessage(ChatRole.System, content);
	}

	@Override
	public ChatMessage createUserMessage(String content) {
		return OpenAIFactory.createMessage(ChatRole.User, content);
	}

	@Override
	public ChatMessage createAssistantMessage(String content) {
		return OpenAIFactory.createMessage(ChatRole.Assistant, content);
	}

}
