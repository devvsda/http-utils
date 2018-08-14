package com.devsda.utils.httputils.loader;

import com.devsda.utils.httputils.DummyClass;
import com.devsda.utils.httputils.models.HealthCheck;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;

public class JsonLoaderTest {

    @Test
    public void loadObject() throws JsonProcessingException {

        HealthCheck healthCheck = new HealthCheck();
        healthCheck.setEchoString("Inqalab-Zindabad!!");
        healthCheck.setHostName("World");

        String sObject = JsonLoader.loadObject(healthCheck);

        System.out.println(sObject);
    }

    @Test
    public void loadObjectFromFileTest() throws IOException {

        String fileName = "src/test/resources/dummy_class_test.json";

        DummyClass dummyClass = JsonLoader.loadFile(fileName, DummyClass.class);

        System.out.println(dummyClass);

    }

    @Test
    public void loadObjectResourceTest() throws IOException {

        String fileName = "dummy_class_test.json";

        DummyClass dummyClass = JsonLoader.loadFileFromResources(fileName, DummyClass.class);

        System.out.println(dummyClass);

    }
}
