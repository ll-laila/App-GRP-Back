package org.sir.appgestionstock;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.springframework.context.annotation.Primary;

@SpringBootApplication
public class Application {
    private static ConfigurableApplicationContext ctx;

    public static void main(String[] args) {
        ctx = SpringApplication.run(Application.class, args);
    }

    public static ConfigurableApplicationContext getCtx() {
        return ctx;
    }

    @Bean
    @Primary
    public ObjectMapper objectMapper() {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        objectMapper.disable(SerializationFeature.FAIL_ON_EMPTY_BEANS);
        return objectMapper;
    }



    @Bean
    public JavaTimeModule javaTimeModule() {
        return new JavaTimeModule();
    }
}
