package com.library.openai.handles;

import com.library.openai.services.LlmContext;

public interface RequestBuilder {
	String buildRequestBody(LlmContext context, boolean useStream);
}
