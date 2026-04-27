package com.library.openai.dtos;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

@Builder
@Data
public class InputSchema implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Builder.Default
	private String type = "object";
	
	@NonNull
	private Map<String, PropertiesSchema> properties;
	@NonNull
	List<String> required;
}
