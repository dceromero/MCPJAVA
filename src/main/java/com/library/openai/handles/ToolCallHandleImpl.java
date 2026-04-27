package com.library.openai.handles;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.library.openai.dtos.LlmFunciton;
import com.library.openai.dtos.Tool;
import com.library.openai.dtos.ToolExecArgs;
import com.library.openai.dtos.response.ToolCall;
import com.library.openai.dtos.response.ToolCallResult;
import com.library.openai.factories.OpenAIFactory;
import com.library.openai.services.ToolProvider;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ToolCallHandleImpl implements ToolCallHandle {

	private final List<ToolProvider> providers;
	private Map<String, LlmFunciton> tools;
	private List<Tool> function;

	@Override
	public List<Tool> getTool() {
		if (tools == null) {
			tools = new HashMap<>();
			if (providers != null) {
				function = new ArrayList<>();
				providers.forEach(provider -> {
					provider.getTools().forEach(tool -> {
						if (!tools.containsKey(tool.getName())) {
							tools.put(tool.getName(), new LlmFunciton(OpenAIFactory.createFunction(tool), provider));
							function.add(tool);
						}
					});
				});
			}

		}
		return function;
	}

	@Override
	public ToolCallResult execTool(ToolCall tocCall) {
		ToolExecArgs toolExecArgs = OpenAIFactory.createToolExecArgs(tocCall);
		String response = tools.get(toolExecArgs.getToolName()).getProvider().execTool(toolExecArgs);
		return ToolCallResult.builder().toolCallId(toolExecArgs.getMessageId()).content(response).build();
	}

}
