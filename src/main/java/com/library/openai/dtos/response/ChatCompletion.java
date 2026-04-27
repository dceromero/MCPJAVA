package com.library.openai.dtos.response;

import java.io.Serializable;
import java.util.List;

import lombok.Data;

@Data
public class ChatCompletion implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String id;
	private String model;
	List<Choice> choices;	
}
