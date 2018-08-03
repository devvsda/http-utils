package com.devsda.utils.httputils.util;

import com.devsda.utils.httputils.loader.JsonLoader;
import com.devsda.utils.httputils.models.HealthCheck;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;

public class ObjectBuilderTest {


    @Test
    public void buildTest() throws JsonProcessingException, UnsupportedEncodingException, IOException {



        HealthCheck healthCheck = new HealthCheck();
        healthCheck.setEchoString("Inqalab-Zindabad!!");
        healthCheck.setHostName("World");

        String sObject = JsonLoader.loadObject(healthCheck);

        InputStream stream = new ByteArrayInputStream(sObject.getBytes(StandardCharsets.UTF_8.name()));

        HealthCheck healthCheck1 = ObjectBuilder.build(stream, HealthCheck.class);

        System.out.println(healthCheck1);
    }
}
