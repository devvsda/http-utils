package com.devsda.utils.httputils.methods;

import com.devsda.utils.httputils.HttpMethod;
import com.devsda.utils.httputils.constants.Protocol;
import org.apache.http.HttpEntity;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.HttpResponseException;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.HttpClientBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Map;

public class HttpPostMethod extends HttpMethod {

    private static final Logger log = LoggerFactory.getLogger(HttpPostMethod.class);

    public <T> T call(Protocol scheme, String hostname, String port, String path, Map<String, String> parameters, Map<String, String> headers, HttpEntity body, Class<T> clazz) throws URISyntaxException, IOException {

        log.info(String.format("Requesting post call to server : %s", hostname));

        HttpClient httpClient = HttpClientBuilder.create().build();

        HttpRequest postRequest = buildRequest(scheme, hostname, port, path, parameters, headers, body);

        HttpResponse httpResponse = httpClient.execute((HttpUriRequest) postRequest);

        int status = httpResponse.getStatusLine().getStatusCode();

        if (status != 200) {
            log.info(String.format("Status : %s", httpResponse.getStatusLine()));
            throw new HttpResponseException(status, "Failed to execute post request");
        }

        log.info(String.format("Successfully got response from server : %s", hostname));

        return getResponse(httpResponse.getEntity(), clazz);
    }

    public void call(URL url, Map<String, String> headers, String body) {

    }

    protected HttpRequest buildRequest(Protocol scheme, String hostname, String port, String path, Map<String, String> parameters, Map<String, String> headers, HttpEntity body) throws URISyntaxException, UnsupportedEncodingException {

        HttpPost postRequest = new HttpPost();

        URI uri = buildURI(scheme.getProtocol(), hostname, port, path, parameters);

        log.info(String.format("URI : %s", uri.toString()));

        postRequest.setURI(uri);

        addHeaders(postRequest, headers);

        postRequest.setEntity(body/*new ByteArrayEntity(body.getBytes("UTF-8"))*/);

        log.info(String.format("Post request : %s", postRequest));

        return postRequest;
    }

}
