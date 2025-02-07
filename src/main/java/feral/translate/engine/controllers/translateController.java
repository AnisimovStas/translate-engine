package feral.translate.engine.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import feral.translate.engine.services.TranslatorService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/translate")
@RequiredArgsConstructor
public class translateController {

    private final TranslatorService translatorService;

    @GetMapping
    public String translate(@RequestParam("text") String text) throws JsonProcessingException {
        return translatorService.translate(text);
    }
}
