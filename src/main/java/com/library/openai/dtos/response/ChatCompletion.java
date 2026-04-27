package com.library.openai.dtos.response;

import java.util.List;

import lombok.Data;

@Data
public class ChatCompletion {
	private String id;
	private String model;
	List<Choice> choices;	
}
