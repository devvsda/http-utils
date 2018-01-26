package com.devsda.utils.httputils.loader;

import com.devsda.utils.httputils.models.HealthCheck;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.BeforeClass;
import org.junit.Test;

public class JsonLoaderTest {

    @Test
    public void loadObject() throws JsonProcessingException {

        HealthCheck healthCheck = new HealthCheck();
        healthCheck.setEchoString("Inqalab-Zindabad!!");
        healthCheck.setHostName("World");

        String sObject = JsonLoader.loadObject(healthCheck);

        System.out.println(sObject);
    }
}
