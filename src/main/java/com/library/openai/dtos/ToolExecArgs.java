package com.library.openai.dtos;

import java.io.Serializable;
import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Data;


@AllArgsConstructor
@Data
public class ToolExecArgs implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String messageId;
	private String toolName;
	private Map<String, Object> argsTool;
}
