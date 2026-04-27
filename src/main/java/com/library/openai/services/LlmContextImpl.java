package com.library.openai.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.library.openai.dtos.ChatMessage;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class LlmContextImpl implements LlmContext {
	
	private List<ChatMessage> _messages = new ArrayList<>();
	@Override
	public void add(ChatMessage message) {
		_messages.add(message);

	}

	@Override
	public void addRange(List<ChatMessage> messages) {
		messages.forEach(this::add);

	}

	@Override
	public List<ChatMessage> getMessages() {
		return _messages;
	}

}
