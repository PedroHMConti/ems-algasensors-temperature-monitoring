package com.algaworks.algasensors.temperature.monitoring.api.config.jackson;


import io.hypersistence.tsid.TSID;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import tools.jackson.databind.module.SimpleModule;

@Configuration
public class TSIDJacksonConfig {

    @Bean
    public SimpleModule tsidModule() {
        SimpleModule module = new SimpleModule();
        module.addSerializer(TSID.class, new TSIDToStringSerializer());
        return module;
    }
}
