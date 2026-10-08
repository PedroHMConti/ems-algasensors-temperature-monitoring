package com.algaworks.algasensors.temperature.monitoring.api.config.jackson;

import io.hypersistence.tsid.TSID;
import tools.jackson.core.JacksonException;
import tools.jackson.core.JsonParser;
import tools.jackson.databind.DeserializationContext;
import tools.jackson.databind.ValueDeserializer;

public class StringToTSIDDeserializer extends ValueDeserializer<TSID> {

    @Override
    public TSID deserialize(JsonParser p, DeserializationContext ctxt) throws JacksonException {
        return TSID.from(p.getText());
    }
}