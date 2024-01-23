package com.kcl.util;

import java.io.IOException;

import com.kcl.ast.Program;
import com.kcl.loader.ScopeRef;
import com.kcl.loader.SymbolRef;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.DeserializationFeature;

public class JsonUtil {
    public static Program deserializeProgram(String jsonString) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        return objectMapper.readValue(jsonString, Program.class);
    }

    public static SymbolRef deserializeSymbolRef(String jsonString) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        return objectMapper.readValue(jsonString, SymbolRef.class);
    }

    public static ScopeRef deserializeScopeRef(String jsonString) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        return objectMapper.readValue(jsonString, ScopeRef.class);
    }
}
