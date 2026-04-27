package com.library.openai.handles;

import java.net.http.HttpRequest;

import org.springframework.stereotype.Service;

import com.library.openai.dtos.response.ChatCompletion;
import com.library.openai.dtos.response.ChoiceMessage;
import com.library.openai.factories.OpenAIFactory;
import com.library.openai.services.LlmContext;
import com.library.openai.services.ProvidersHttpClient;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ResponseHandleImpl implements ResponseHandle {

	private final RequestBuilder requestBuilder;
	private final ProvidersHttpClient<HttpRequest, String> clientHttp;
	private final ToolCallHandle toolCallHandle;

	@Override
	public String getResponse(LlmContext context) {
		int maxIteration = 10;
		int currenIteration = 0;
		StringBuilder fullResponse = new StringBuilder();
		while (currenIteration < maxIteration) {
			String json = requestBuilder.buildRequestBody(context, false);
			String jsonResponse = clientHttp.sendHttp(json);
			ChatCompletion chatCompletion = OpenAIFactory.createChatComplation(jsonResponse);
			ChoiceMessage message = chatCompletion.getChoices().get(0).getMessage();
			context.add(message);
			message.getContent().ifPresent(fullResponse::append);

			if (message.toolCalls != null) {
				message.toolCalls.forEach(tool->{
					context.add(toolCallHandle.execTool(tool));
				});
			}else {
				break;
			}
			
		}

		return fullResponse.toString();
	}

}
