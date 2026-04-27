package com.library.openai.handles;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.library.openai.dtos.LlmOptions;
import com.library.openai.dtos.Tool;
import com.library.openai.factories.OpenAIFactory;
import com.library.openai.services.LlmContext;

import lombok.RequiredArgsConstructor;
import tools.jackson.databind.ObjectMapper;

@Service
@RequiredArgsConstructor
public class RequestBuilderImpl implements RequestBuilder {

	private final LlmOptions options;
	private final ObjectMapper objectMapper;
	private final ToolCallHandle toolCallHandle;
	private List<Map<String, Object>> toolList;

	@Override
	public String buildRequestBody(LlmContext context, boolean useStream) {
		Map<String, Object> reqBody = OpenAIFactory.createRequestBody(context, useStream, options);

		List<Tool> functions = toolCallHandle.getTool();
		if (functions != null) {
			toolList = new ArrayList<>();
			functions.forEach(f -> {
				toolList.add(OpenAIFactory.createFunction(f));
			});
			OpenAIFactory.createToolCallRequestBodyProperties(toolList).forEach((key, value) -> {
				reqBody.put(key, value);
			});
		}

		return objectMapper.writeValueAsString(reqBody);
	}

}
