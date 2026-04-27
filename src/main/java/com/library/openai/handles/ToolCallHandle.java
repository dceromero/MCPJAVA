package com.library.openai.handles;

import java.util.List;

import com.library.openai.dtos.Tool;
import com.library.openai.dtos.response.ToolCall;
import com.library.openai.dtos.response.ToolCallResult;

public interface ToolCallHandle {

	List<Tool> getTool();
	
	ToolCallResult execTool(ToolCall tocCall);
	
}
