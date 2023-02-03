package com.k1m743hyun.property;

import java.util.List;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;

@ConfigurationProperties(prefix = "pushgw")
@ConstructorBinding
@RequiredArgsConstructor
@Getter
public class ConfigProperties {

    private final List<String> gw;
}