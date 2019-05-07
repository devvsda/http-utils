package com.devsda.utils.httputils;

import com.devsda.utils.httputils.constants.Protocol;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpEntity;
import org.apache.http.HttpMessage;
import org.apache.http.HttpRequest;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Map;

public abstract class HttpMethod {

    public abstract <T> T call(Protocol scheme, String hostname, String port, String path, Map<String, String> parameters, Map<String, String> headers, HttpEntity body, Class<T> clazz) throws URISyntaxException, IOException;

    public abstract void call(URL url, Map<String, String> headers, String body);

    protected abstract HttpRequest buildRequest(Protocol scheme, String hostname, String port, String path, Map<String, String> parameters, Map<String, String> headers, HttpEntity body) throws URISyntaxException, UnsupportedEncodingException;

    public void addHeaders(HttpMessage httpMessage, Map<String, String> headers) {

        if (headers == null) {
            return;
        }

        for (Map.Entry<String, String> thisHeader : headers.entrySet()) {
            httpMessage.addHeader(thisHeader.getKey(), thisHeader.getValue());
        }

    }

    public URI buildURI(String scheme, String hostname, String port, String path, Map<String, String> parameters) throws URISyntaxException {

        URIBuilder uriBuilder = new URIBuilder();

        uriBuilder.setScheme(scheme).setHost(hostname);

        if (port != null) {
            uriBuilder.setPort(Integer.valueOf(port));
        }

        uriBuilder.setPath(path);

        if (parameters == null) {
            return uriBuilder.build();
        }

        for (Map.Entry<String, String> thisParameter : parameters.entrySet()) {
            uriBuilder.setParameter(thisParameter.getKey(), thisParameter.getValue());
        }

        return uriBuilder.build();

    }

    public <T> T getResponse(HttpEntity httpEntity, Class<T> clazz) throws IOException {

        String response = EntityUtils.toString(httpEntity);

        if (String.class.equals(clazz)) {
            return (T) response;
        }

        return new ObjectMapper().readValue(response, clazz);
    }

}
