package com.library.openai.dtos.response;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class Choice  implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int index;

	@JsonProperty("finish_reason")
	private String finishReason;

	private ChoiceMessage message;
}
