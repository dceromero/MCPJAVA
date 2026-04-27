# LibraryyOpenAI

LibraryyOpenAI es una pequeña librería Java para interactuar con servicios de chat estilo OpenAI mediante un cliente plugable. Proporciona una abstracción `ChatClient` y un ejemplo de uso interactivo por consola.
https://github.com/dceromero/ClientMCP

## Características

- Abstracción sencilla de cliente de chat (`ChatClient`, `ChatContainer`)
- Ejemplo interactivo por consola
- Configurable: URL base, endpoint, modelo y cabecera de autenticación

## Requisitos

- Java 11+ (usar la versión objetivo del proyecto)
- Maven o Gradle
- Acceso a red al API destino

## Instalación

- Con Maven:
  - Compilar e instalar localmente:
      mvn clean install
- Con Gradle:
  - Incluir el JAR compilado en tu build o publicar en tu repositorio privado

## Configuración

Al crear el servicio debes establecer opciones como:

- `baseUrl` \- URL base de la API
- `endpoint` \- ruta del endpoint de chat
- `model` \- identificador del modelo
- `authenticationHeaderValue` \- por ejemplo `Bearer <API_KEY>`

Ejemplo (pseudocódigo a incluir en tu `Main` o en la inicialización):
    ChatClient chatClient = new ChatContainer().service(options -> {
        options.setBaseUrl("https://api.example.com");
        options.setEndpoint("/v1/chat/completions");
        options.setModel("gpt-3.5-turbo");
        options.setAuthenticationHeaderValue("Bearer YOUR_API_KEY");
    });

## Variables de entorno (Windows)

Se recomienda guardar la clave en una variable de entorno y leerla desde la aplicación:

- Command Prompt:
    setx OPENAI_API_KEY "tu_api_key_aqui"
- PowerShell (persistente en la sesión actual):
    $env:OPENAI_API_KEY = "tu_api_key_aqui"

También se pueden definir:
- `OPENAI_BASE_URL` (ej.: `https://api.openai.com`)
- `OPENAI_ENDPOINT` (ej.: `/v1/chat/completions`)
- `OPENAI_MODEL` (ej.: `gpt-3.5-turbo`)

## Uso

La carpeta `ClientOpenAI` incluye un ejemplo interactivo (`com.library.openai.Chat`) que lee del consola y envía mensajes al `ChatClient`.

Para ejecutar:

- Compilar:
    mvn clean package
- Ejecutar con plugin exec:
    mvn exec:java -Dexec.mainClass="com.library.openai.Main"
- O ejecutar el JAR:
    java -cp target/tu-artifact.jar com.library.openai.Main

El flujo típico:
- Se añade un mensaje de sistema (ej.: `eres un asistente amigable y servicial`)
- Se lee la entrada del usuario y se llama a `chatClient.chat(userPrompt)`
- Comandos útiles: escribir `exit` para salir
