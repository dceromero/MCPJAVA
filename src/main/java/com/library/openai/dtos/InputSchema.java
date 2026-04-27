package com.library.openai.dtos;

import java.util.List;
import java.util.Map;

import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

@Builder
@Data
public class InputSchema {

	@Builder.Default
	private String type = "object";
	
	@NonNull
	private Map<String, PropertiesSchema> properties;
	@NonNull
	List<String> required;
}
