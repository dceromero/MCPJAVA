package com.library.openai.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum HttpStatusCode {

	OK(200), NOT_FOUND(404), INTERNAL_SERVER_ERROR(500);

	private final int statusCode;
}
