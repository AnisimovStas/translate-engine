package feral.translate.engine.client;

import feign.Headers;
import feral.translate.engine.domain.DeepTranslateBody;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(url = "${services.translate.url}", name = "TranslateEngineClient")
public interface TranslateClient {

    @GetMapping("${services.translate.path}")
    String translateSingle(
        @RequestHeader("x-rapidapi-host") String rapidApiHost,
        @RequestHeader("x-rapidapi-key") String rapidApiKey,
        @RequestBody DeepTranslateBody body

    );
}
