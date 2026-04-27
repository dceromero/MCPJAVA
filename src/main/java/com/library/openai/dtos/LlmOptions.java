package com.library.openai.dtos;

import java.io.Serializable;

import lombok.Data;

@Data
public class LlmOptions implements Serializable {

	private static final long serialVersionUID = 1L;
	public String model;
	public String BaseUrl;
	public String Endpoint;
	public String AuthenticationHeaderName = "Authorization";
	public String AuthenticationHeaderValue;
	public double Temperature = 0.5;
	public int MaxTokens = 4092;
}
