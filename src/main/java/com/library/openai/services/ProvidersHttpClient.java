package com.library.openai.services;

public interface ProvidersHttpClient<T,R> {

	T createHttp(R r);
	
	String sendHttp(R r);
	
}
