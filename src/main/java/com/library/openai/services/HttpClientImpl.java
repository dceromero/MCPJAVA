package com.library.openai.services;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import org.springframework.stereotype.Service;

import com.library.openai.dtos.LlmOptions;
import com.library.openai.enums.HttpStatusCode;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class HttpClientImpl implements ProvidersHttpClient<HttpRequest, String> {

	private final LlmOptions options;

	@Override
	public HttpRequest createHttp(String request) {
		return HttpRequest.newBuilder().uri(URI.create(options.BaseUrl + options.Endpoint))
				.header("Content-Type", "application/json")
				.header(options.AuthenticationHeaderName, options.AuthenticationHeaderValue)
				.POST(HttpRequest.BodyPublishers.ofString(request)).build();
	}

	@Override
	public String sendHttp(String json) {
		HttpRequest request = this.createHttp(json);
		 HttpClient client = HttpClient.newHttpClient();
		try {
			HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
			if (response.statusCode() == HttpStatusCode.OK.getStatusCode()) {
				return response.body();
			}
			return String.format("Error con Status : %s y Message: %s", response.statusCode(), response.body());
		} catch (Exception ex) {
			return String.format("Error en %S", ex.getMessage());
		}
	}

}
