package com.library.openai.dtos;

import java.io.Serializable;

import lombok.Data;

@Data
public class FunctionCall implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String name;

	private String arguments;
}
