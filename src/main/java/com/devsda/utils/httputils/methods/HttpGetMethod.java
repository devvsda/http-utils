package com.devsda.utils.httputils.methods;

import com.devsda.utils.httputils.HttpMethod;
import com.devsda.utils.httputils.util.ObjectBuilder;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.HttpResponseException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.HttpClientBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Map;

public class HttpGetMethod extends HttpMethod {

    private static final Logger log = LoggerFactory.getLogger(HttpGetMethod.class);


    public <T> T call(String hostname, String port, String path, Map<String, String> parameters, Map<String, String> headers, String body, Class<T> clazz) throws URISyntaxException, IOException {

        log.info("Executing get request");

        HttpClient httpClient = HttpClientBuilder.create().build();

        HttpRequest getClient = buildRequest(hostname, port, path, parameters, headers, body);

        HttpResponse response = httpClient.execute((HttpUriRequest) getClient);

        int statusCode = response.getStatusLine().getStatusCode();

        if(statusCode != 200) {
            throw new HttpResponseException(statusCode, "Failed to get response");
        }

        return getResponse(response.getEntity(), clazz);
    }

    public void call(URL url, Map<String, String> headers, String body) {

    }

    protected HttpRequest buildRequest(String hostname, String port, String path, Map<String, String> parameters, Map<String, String> headers, String body) throws URISyntaxException {

        HttpGet getRequest = new HttpGet();

        URI uri = buildURI(hostname, port, path, parameters);

        log.info(String.format("URI : %s", uri.toString()));

        getRequest.setURI(uri);

        addHeaders(getRequest, headers);

        // getRequest.releaseConnection();

        return getRequest;
    }

    private <T> T getResponse(HttpEntity httpEntity, Class<T> clazz) throws IOException {

        InputStream inputStream = httpEntity.getContent();

        return ObjectBuilder.build(inputStream, clazz);

    }
}
