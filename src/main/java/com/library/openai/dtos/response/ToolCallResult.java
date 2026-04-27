package com.library.openai.dtos.response;

import java.io.Serializable;
import java.util.Optional;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.library.openai.dtos.ChatMessage;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Setter
public class ToolCallResult implements ChatMessage, Serializable {
	private static final long serialVersionUID = 1L;

	private String content;

	@Builder.Default
	private String role = "tool";

	@Getter
	@JsonProperty("tool_call_id")
	public String toolCallId;

	@Override
	public String getRole() {
		return role;
	}

	@Override
	public Optional<String> getContent() {
		return content == null ? Optional.empty() : Optional.of(content);
	}

}
