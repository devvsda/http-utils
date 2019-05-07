package com.devsda.utils.httputils.methods;

import com.devsda.utils.httputils.constants.Protocol;
import org.apache.http.entity.FileEntity;
import org.apache.http.entity.StringEntity;
import org.junit.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;

public class HttpPostMethodTest {

    private static final Logger log = LoggerFactory.getLogger(HttpPostMethodTest.class);

    private static HttpPostMethod httpPostMethod = null;

    @BeforeClass
    public static void setupSuit() {
        log.info("Setting up test suit.");
        httpPostMethod = new HttpPostMethod();
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
    public void postMethodTest() throws URISyntaxException, IOException {

        String hostname = "127.0.0.1";
        String port = "8080";
        String path = "/dominos-shepherd-client/order-management-workflow/validateOrder";

        Map<String, String> headers = new HashMap<String, String>();
        headers.put("Content-Type", "application/json");

        String body = ""; // JsonLoader.loadObject(new DummyClass("inqalab-zindabad"));

        System.out.println(httpPostMethod.call(Protocol.HTTPS, hostname, port, path, null, headers, new StringEntity(body), String.class));
    }

    @Test
    public void postMethodImageUploadTest() throws URISyntaxException, IOException {

        // http://40.121.145.83:8080/auto-classifier-core/healthCheck/inqalab_zindabad

        String hostname = "127.0.0.1";
        String port = "8080";
        String path = "/auto-classifier-core/receipt-operation/auto-classify/hitesh";

        Map<String, String> headers = new HashMap<String, String>();
        headers.put("Content-Type", "application/octet-stream");

        File picfile = new File("/Users/hijhamb/Desktop/blob_testing.jpg");
        if (!picfile.exists()) throw new AssertionError();


        httpPostMethod.call(Protocol.HTTP, hostname, port, path, null, headers, new FileEntity(picfile), String.class);

    }

    class DummyClass {

        private String echoText;

        public DummyClass(String echoText) {
            this.echoText = echoText;
        }

        public String getEchoText() {
            return echoText;
        }

        public void setEchoText(String echoText) {
            this.echoText = echoText;
        }

        @Override
        public String toString() {
            return "DummyClass{" +
                    "echoText='" + echoText + '\'' +
                    '}';
        }
    }
}
