package com.testvagrant.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;

public class JsonUtils {
    public static <T> T getObject(String json, Class<T> type) {

        ObjectMapper mapper = new ObjectMapper();

        if (json == null) {
            return null;
        }
        try {
            return mapper.readValue(json, type);
        } catch (IOException e) {
            return null;
        }
    }

    public static String getJson(Object src) throws Exception {
        ObjectMapper om = new ObjectMapper();
        return om.writeValueAsString(src);
    }

}
