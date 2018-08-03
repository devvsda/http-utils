package com.devsda.utils.httputils.methods;

import com.devsda.utils.httputils.models.HealthCheck;
import org.junit.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;


public class HttpGetMethodTest {

    private static final Logger log = LoggerFactory.getLogger(HttpGetMethodTest.class);

    private static HttpGetMethod httpGetMethod = null;

    @BeforeClass
    public static void setupSuit() {
        log.info("Setting up test suit.");
        httpGetMethod = new HttpGetMethod();
    }

    @AfterClass
    public static void tearDownSuit() {
        log.info("Tearing down test suit.");
    }

    @Before
    public void setup() {
        log.info("Setting up test environment.");
    }

    @After
    public void tearDown() {
        log.info("Tearing down test environment.");
    }

    @Test
    public void httpGetMethodTest() throws URISyntaxException, IOException {

        log.info("Executing test");

        String hostname = "127.0.0.1";
        String port = "8080";
        String path = "/shephard-manager/healthCheck";

        Map<String, String> parameters = new HashMap<String, String>();
        parameters.put("echoText", "inqalab-zindabad");

        Map<String, String> headers = new HashMap<String, String>();
        headers.put("Content-Type", "application/json");

        String body = null;

        HealthCheck healthCheck = httpGetMethod.call(hostname, port, path, parameters, headers, body, HealthCheck.class);

        System.out.println(healthCheck);
    }
}
