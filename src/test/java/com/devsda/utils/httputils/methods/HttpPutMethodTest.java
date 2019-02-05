package com.devsda.utils.httputils.methods;

import com.devsda.utils.httputils.constants.Protocol;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.apache.http.entity.StringEntity;
import org.junit.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;

public class HttpPutMethodTest {

    private static final Logger log = LoggerFactory.getLogger(HttpPostMethodTest.class);

    private static HttpPutMethod httpPutMethod = null;

    @BeforeClass
    public static void setupSuit() {
        log.info("Setting up test suit.");
        httpPutMethod = new HttpPutMethod();
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

    @Ignore
    @Test
    public void postMethodTest() throws JsonProcessingException, URISyntaxException, IOException {

        String hostname = "XXX";
        String port = null;
        String path = "YYY";

        Map<String, String> headers = new HashMap<String, String>();
        headers.put("Content-Type", "application/json");

        String body = "{ \"notes\" : \"notes_processing_testing\" }";

        System.out.println(httpPutMethod.call(Protocol.HTTPS, hostname, port, path, null, headers, new StringEntity(body), String.class));
    }
}
