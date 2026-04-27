package com.library.openai.dtos;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class PropertiesSchema implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String type;
	private String description;
}
