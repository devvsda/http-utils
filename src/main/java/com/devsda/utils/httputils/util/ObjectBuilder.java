package com.devsda.utils.httputils.util;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.InputStream;

public class ObjectBuilder {

    public static <T> T  build(InputStream inputStream, Class<T> clazz) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        T object = objectMapper.readValue(inputStream, clazz);
        return object;
    }

}
