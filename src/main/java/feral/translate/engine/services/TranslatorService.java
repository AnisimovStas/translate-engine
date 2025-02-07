package feral.translate.engine.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import feral.translate.engine.client.TranslateClient;

import feral.translate.engine.domain.DeepTranslateBody;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TranslatorService {

    private final TranslateClient translateClient;
    private final ObjectMapper objectMapper;
    public static final String SOURCE_LANGUAGE = "en";
    public static final String TARGET_LANGUAGE = "ru";
    public static final String CLIENT = "qtx";
    public static final String DT = "t";

    @Value("${services.translate.base-url}")
    private String hostHeader;
    @Value("${services.translate.api-key}")
    private String apiKey;

    public String translate(String text) throws JsonProcessingException {

        DeepTranslateBody body = DeepTranslateBody.builder()
            .q(text)
            .source(SOURCE_LANGUAGE)
            .target(TARGET_LANGUAGE)
            .build();

        String response = translateClient.translateSingle(hostHeader, apiKey, body);
        JsonNode responseJSON = objectMapper.readTree(response);
        return responseJSON.path("data").path("translations").path("translatedText").asText();
    }

}
