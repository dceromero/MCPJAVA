package com.library.openai.services.container;

import java.net.http.HttpRequest;
import java.util.List;
import java.util.function.Consumer;

import com.library.openai.dtos.LlmOptions;
import com.library.openai.handles.RequestBuilder;
import com.library.openai.handles.RequestBuilderImpl;
import com.library.openai.handles.ResponseHandle;
import com.library.openai.handles.ResponseHandleImpl;
import com.library.openai.handles.ToolCallHandle;
import com.library.openai.handles.ToolCallHandleImpl;
import com.library.openai.provider.example.WeatherToolProvider;
import com.library.openai.services.ChatClient;
import com.library.openai.services.ChatClientImpl;
import com.library.openai.services.HttpClientImpl;
import com.library.openai.services.LlmClient;
import com.library.openai.services.LlmClientImpl;
import com.library.openai.services.LlmContext;
import com.library.openai.services.LlmContextImpl;
import com.library.openai.services.ProvidersHttpClient;
import com.library.openai.services.ToolProvider;

import tools.jackson.databind.ObjectMapper;

public class ChatContainer implements ContainerServices<ChatClient, Consumer<LlmOptions>> {

	public ChatClient service(Consumer<LlmOptions> options) {
		ObjectMapper objMapper = new ObjectMapper();
		LlmContext context = new LlmContextImpl();
		LlmOptions llmOptions = new LlmOptions();
		List<ToolProvider> prov = List.of(new WeatherToolProvider());
		ToolCallHandle toolCallHandle = new ToolCallHandleImpl(prov);
		if (options != null) {
			options.accept(llmOptions);
		}
		RequestBuilder req = new RequestBuilderImpl(llmOptions, objMapper, toolCallHandle);
		ProvidersHttpClient<HttpRequest, String> provHttp = new HttpClientImpl(llmOptions);
		ResponseHandle resHandle = new ResponseHandleImpl(req, provHttp, toolCallHandle);
		LlmClient llmClient = new LlmClientImpl(resHandle);
		return new ChatClientImpl(context, llmClient);
	}

	@Override
	public ChatClient service() {
		ObjectMapper objMapper = new ObjectMapper();
		LlmContext context = new LlmContextImpl();
		LlmOptions llmOptions = new LlmOptions();
		ToolCallHandle toolCallHandle = new ToolCallHandleImpl(null);
		RequestBuilder req = new RequestBuilderImpl(llmOptions, objMapper, toolCallHandle);
		ProvidersHttpClient<HttpRequest, String> provHttp = new HttpClientImpl(llmOptions);
		ResponseHandle resHandle = new ResponseHandleImpl(req, provHttp, toolCallHandle);
		LlmClient llmClient = new LlmClientImpl(resHandle);
		return new ChatClientImpl(context, llmClient);
	}

}
