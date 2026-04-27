package com.library.openai.provider.example;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.library.openai.dtos.InputSchema;
import com.library.openai.dtos.PropertiesSchema;
import com.library.openai.dtos.Tool;
import com.library.openai.dtos.ToolExecArgs;
import com.library.openai.services.ToolProvider;

public class WeatherToolProvider implements ToolProvider {

	private String toolName = "GetWeather";

	@Override
	public List<Tool> getTools() {

		Map<String, PropertiesSchema> prop = new HashMap<>();
		prop.put("location", new PropertiesSchema("string", "La ubicación para la cual obtener el clima."));
		prop.put("unit", new PropertiesSchema("string",
				"La unidad de temperatura (opcional, 'Celsius' o 'Fahrenheit', por defecto es 'Celsius')."));

		return List.of(new Tool(toolName, "Obtiene el clima actual para una ubicación especificada.",
				InputSchema.builder().properties(prop).required(List.of("location")).build()));
	}

	@Override
	public String execTool(ToolExecArgs tool) {
		switch (tool.getToolName()){
		case "GetWeather": {
			int min = -10;
			int max = 35;
			float temp = (int) (Math.random() * (max - min + 1)) + min;
			String location = tool.getArgsTool().get("location").toString();
			return String.format("La temperatura en %s es de %f", location, temp);
		}
		default:
			return ("Unexpected value: " + tool.getToolName());
		}
	}

}
