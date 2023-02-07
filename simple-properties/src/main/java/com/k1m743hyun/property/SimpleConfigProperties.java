package com.k1m743hyun.property;

import java.util.List;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;

@ConfigurationProperties(prefix = "agent.file")
@ConstructorBinding
@RequiredArgsConstructor
public class SimpleConfigProperties {

    public final Path base;
    public final Sub sub;

    @RequiredArgsConstructor
    static class Base {
        public final String path;
    }

    @RequiredArgsConstructor
    static class Path {
        public final String path;
    }

    @RequiredArgsConstructor
    static class Sub {

        public final Path etc;
        public final Path status;
        public final Batch batch;

        @RequiredArgsConstructor
        static class Batch {

            public final String path;
            public final Path meta;
            public final Path monitor;
        }
    }
}