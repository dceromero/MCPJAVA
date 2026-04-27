package com.library.openai.services;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ChatClientImpl implements ChatClient {

	private final LlmContext _context;
	private final LlmClient _llmClient;

	@Override
	public void addSystem(String message) {
		_context.add(_llmClient.createSystemMessage(message));

	}

	@Override
	public String chat(String message) {
		_context.add(_llmClient.createUserMessage(message));
		return _llmClient.chat(_context);
	}

}
