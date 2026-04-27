package com.library.openai.dtos.response;

import com.library.openai.dtos.FunctionCall;

import lombok.Data;

@Data
public class ToolCall {

	private String id;
	public String type;
	public FunctionCall function;
}
