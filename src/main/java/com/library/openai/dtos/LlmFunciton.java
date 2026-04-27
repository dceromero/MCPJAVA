package com.library.openai.dtos;

import java.util.Map;

import com.library.openai.services.ToolProvider;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class LlmFunciton {

	private  Map<String, Object> function;
	
	private ToolProvider provider;
	
}
