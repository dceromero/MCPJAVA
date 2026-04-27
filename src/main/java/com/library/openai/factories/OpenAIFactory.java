package com.library.openai.factories;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.library.openai.dtos.ChatMessage;
import com.library.openai.dtos.ChatMessageImpl;
import com.library.openai.dtos.LlmOptions;
import com.library.openai.dtos.Tool;
import com.library.openai.dtos.ToolExecArgs;
import com.library.openai.dtos.response.ChatCompletion;
import com.library.openai.dtos.response.ToolCall;
import com.library.openai.enums.ChatRole;
import com.library.openai.services.LlmContext;

import tools.jackson.databind.ObjectMapper;

public class OpenAIFactory {

	public static ChatMessage createMessage(ChatRole role, String content) {
		return new ChatMessageImpl(content, role.name().toLowerCase());
	}

	public static Map<String, Object> createRequestBody(LlmContext context, boolean stream, LlmOptions options) {
		List<ChatMessage> messages = context.getMessages();
		return new HashMap<String, Object>() {
			private static final long serialVersionUID = 1L;
			{
				put("model", options.getModel());
				put("stream", stream);
				put("messages", messages);
				put("temperature", options.getTemperature());
				put("max_completion_tokens", options.getMaxTokens());
			}
		};

	}

	public static ChatCompletion createChatComplation(String jsonResponse) {
		ObjectMapper objMapper = new ObjectMapper();
		return objMapper.readValue(jsonResponse, ChatCompletion.class);
	}

	public static Map<String, Object> createFunction(Tool tool){
		return new HashMap<String, Object>() {
			private static final long serialVersionUID = 1L;
			{
				put("type", "function");
				put("function", tool);
			}
		};
	}
	
	public static Map<String, Object> createToolCallRequestBodyProperties(List<Map<String, Object>> tools){
		return new HashMap<String, Object>() {
			private static final long serialVersionUID = 1L;
			{
				put("tools", tools);
				put("tool_choice", "auto");
			}
		};
	}
	
	public static ToolExecArgs createToolExecArgs(ToolCall tool) {
		return new ToolExecArgs(tool.getId(), tool.function.getName(), tool.function.getArguments());
	}
}
