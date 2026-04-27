package com.library.openai.dtos;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@AllArgsConstructor
@Builder
@Data
public class Tool implements Serializable {
//TODO: Cambiar el Imput 
	private static final long serialVersionUID = 1L;
	private String name;
	private String description;
	@JsonProperty("parameters")
	private InputSchema inputSchema;
}
