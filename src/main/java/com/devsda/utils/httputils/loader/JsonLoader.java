package com.devsda.utils.httputils.loader;

import com.devsda.utils.httputils.exceptions.HttpUtilsInternalException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public class JsonLoader {

    public static <T> String loadObject(Object object) throws JsonProcessingException {

        ObjectMapper objectMapper = new ObjectMapper();
        String strigyfiedObject = objectMapper.writeValueAsString(object);
        return strigyfiedObject;

    }

    public static <T> T loadFile(String fileName, Class<T> clazz) throws IOException {

        ObjectMapper objectMapper = new ObjectMapper();

        File file = new File(fileName);

        if (!file.exists() || file.isDirectory()) {
            throw new HttpUtilsInternalException(String.format("File either missing or not in file format. File name : %s", fileName));
        }

        T object = objectMapper.readValue(file, clazz);

        return object;
    }

    public static <T> T loadFileFromResources(String fileName, Class<T> clazz) throws IOException {

        ObjectMapper objectMapper = new ObjectMapper();

        InputStream inputStream = JsonLoader.class.getClassLoader().getResourceAsStream(fileName);

        T object = objectMapper.readValue(inputStream, clazz);

        return object;
    }
}
