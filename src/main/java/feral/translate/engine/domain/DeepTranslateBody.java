package feral.translate.engine.domain;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class DeepTranslateBody {
    String q;
    String source;
    String target;
}
