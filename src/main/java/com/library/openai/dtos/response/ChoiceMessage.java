package com.library.openai.dtos.response;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.library.openai.dtos.ChatMessage;

import lombok.Getter;
import lombok.Setter;

@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class ChoiceMessage implements ChatMessage, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String content = null;
	
	private String role;

	@Getter
	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonProperty("tool_calls")
	public List<ToolCall> toolCalls;	
	
	@Override
	public String getRole() {
		return role;
	}

	@Override
	public Optional<String> getContent() {
		return Optional.ofNullable(content);
	}
}
