package com.library.openai;

import java.net.http.HttpRequest;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.library.openai.dtos.LlmOptions;
import com.library.openai.handles.RequestBuilder;
import com.library.openai.handles.RequestBuilderImpl;
import com.library.openai.handles.ResponseHandle;
import com.library.openai.handles.ResponseHandleImpl;
import com.library.openai.handles.ToolCallHandle;
import com.library.openai.services.ChatClient;
import com.library.openai.services.ChatClientImpl;
import com.library.openai.services.LlmClient;
import com.library.openai.services.LlmClientImpl;
import com.library.openai.services.LlmContext;
import com.library.openai.services.LlmContextImpl;
import com.library.openai.services.ProvidersHttpClient;

import tools.jackson.databind.ObjectMapper;

//@SpringBootApplication
@Configuration
public class LibraryOpenAiApplication {

	public static void main(String[] args) {
		// SpringApplication.run(LibraryOpenAiApplication.class, args);
	}

	@Bean
	@ConditionalOnMissingBean(RequestBuilder.class)
	RequestBuilder requestBuilder(LlmOptions options, ObjectMapper objectMapper, ToolCallHandle toolHandle) {
		return new RequestBuilderImpl(options, objectMapper, toolHandle);
	}

	@Bean
	@ConditionalOnMissingBean(ResponseHandle.class)
	ResponseHandle responseHandle(RequestBuilder requestBuilder, ProvidersHttpClient<HttpRequest, String> clientHttp, ToolCallHandle toolHandle) {
		return new ResponseHandleImpl(requestBuilder, clientHttp, toolHandle);
	}

	@Bean
	@ConditionalOnMissingBean(ChatClient.class)
	ChatClient chatClient(LlmContext _context, LlmClient _llmClient) {
		return new ChatClientImpl(_context, _llmClient);
	}

	@Bean
	@ConditionalOnMissingBean(LlmClient.class)
	LlmClient llmClient(ResponseHandle responseHandle) {
		return new LlmClientImpl(responseHandle);
	}

	@Bean
	@ConditionalOnMissingBean(LlmContext.class)
	LlmContext llmContext() {
		return new LlmContextImpl();
	}

}
