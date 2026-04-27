package com.library.openai.dtos.response;

import java.io.Serializable;

import com.library.openai.dtos.FunctionCall;

import lombok.Data;

@Data
public class ToolCall implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String id;
	public String type;
	public FunctionCall function;
}
