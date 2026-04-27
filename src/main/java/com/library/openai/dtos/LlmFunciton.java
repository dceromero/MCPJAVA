package com.library.openai.dtos;

import java.io.Serializable;
import java.util.Map;

import com.library.openai.services.ToolProvider;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class LlmFunciton implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private  Map<String, Object> function;
	
	private ToolProvider provider;
	
}
