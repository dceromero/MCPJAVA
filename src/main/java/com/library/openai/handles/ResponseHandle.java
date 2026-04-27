package com.library.openai.handles;

import com.library.openai.services.LlmContext;

public interface ResponseHandle {
	String getResponse(LlmContext context);
}
