package nurs.abc.dss.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RevealingController {
    @Value("${secret.first}")
    private String _1stSecret;
    @Value("${secret.second}")
    private String _2ndSecret;
    @Value("${non.secret}")
    private String nonSecret;
    
    @GetMapping(value = "/reveal-a-secret", produces = MediaType.APPLICATION_JSON_VALUE)
    public String revealASecret(@RequestParam(name = "ordinal") Long ordinal) {
        if (ObjectUtils.nullSafeEquals(ordinal, 1L)) {
            return _1stSecret;
        } else if (ObjectUtils.nullSafeEquals(ordinal, 2L)) {
            return _2ndSecret;
        } else if (ObjectUtils.nullSafeEquals(ordinal, 3L)) {
            return nonSecret;
        } else {
            return "I can say nothing.";
        }
    }
}
