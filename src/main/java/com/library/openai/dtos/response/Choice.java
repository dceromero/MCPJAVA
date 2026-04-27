package com.library.openai.dtos.response;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class Choice {
	private int index;

	@JsonProperty("finish_reason")
	private String finishReason;

	private ChoiceMessage message;
}
