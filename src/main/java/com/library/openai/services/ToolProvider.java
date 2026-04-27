package com.library.openai.services;

import java.util.List;

import com.library.openai.dtos.Tool;
import com.library.openai.dtos.ToolExecArgs;;

public interface ToolProvider {

	List<Tool> getTools();
	
	String execTool(ToolExecArgs argsTool);
}
