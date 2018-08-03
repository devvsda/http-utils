package com.devsda.utils.httputils.loader;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonLoader {

    public static <T> String loadObject(Object object) throws JsonProcessingException {

        ObjectMapper objectMapper = new ObjectMapper();
        String strigyfiedObject = objectMapper.writeValueAsString(object);
        return strigyfiedObject;

    }
}
