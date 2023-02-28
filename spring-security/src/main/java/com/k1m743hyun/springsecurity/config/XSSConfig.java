package com.k1m743hyun.springsecurity.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.k1m743hyun.springsecurity.util.HTMLCharacterEscapes;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;

@Slf4j
@RequiredArgsConstructor
@Configuration
public class XSSConfig {

    private final ObjectMapper objectMapper;

    @Bean
    public MappingJackson2HttpMessageConverter characterEscapeConverter() {

        ObjectMapper copy = objectMapper.copy();
        copy.getFactory().setCharacterEscapes(new HTMLCharacterEscapes());

        return new MappingJackson2HttpMessageConverter(copy);
    }
}
