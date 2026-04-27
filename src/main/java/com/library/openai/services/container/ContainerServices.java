package com.library.openai.services.container;

public interface ContainerServices<T, R> {
	T service();

	T service(R r);
}
