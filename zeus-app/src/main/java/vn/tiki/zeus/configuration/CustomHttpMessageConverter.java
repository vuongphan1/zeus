package vn.tiki.zeus.configuration;

import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.List;

//@Configuration
public class CustomHttpMessageConverter extends MappingJackson2HttpMessageConverter {

    public CustomHttpMessageConverter() {
        List<MediaType> types = Arrays.asList(
                new MediaType("text", "json", StandardCharsets.UTF_8),
                MediaType.APPLICATION_JSON,
                MediaType.MULTIPART_FORM_DATA,
                MediaType.APPLICATION_FORM_URLENCODED
        );
        super.setSupportedMediaTypes(types);
    }
}
