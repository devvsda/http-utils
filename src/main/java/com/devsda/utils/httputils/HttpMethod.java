package com.devsda.utils.httputils;

import com.devsda.utils.httputils.util.ObjectBuilder;
import org.apache.http.HttpEntity;
import org.apache.http.HttpMessage;
import org.apache.http.HttpRequest;
import org.apache.http.client.utils.URIBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Map;

public abstract class HttpMethod {

    public abstract <T> T call(String hostname, String port, String path, Map<String, String> parameters, Map<String, String> headers, String body, Class<T> clazz) throws URISyntaxException, IOException;

    public abstract void call(URL url, Map<String, String> headers, String body);

    protected abstract HttpRequest buildRequest(String hostname, String port, String path, Map<String, String> parameters, Map<String, String> headers, String body) throws URISyntaxException, UnsupportedEncodingException;

    public void addHeaders(HttpMessage httpMessage, Map<String, String> headers) {

        if(headers == null) {
            return;
        }

        for(Map.Entry<String, String> thisHeader : headers.entrySet()) {
            httpMessage.addHeader(thisHeader.getKey(), thisHeader.getValue());
        }

    }

    public URI buildURI(String hostname, String port, String path, Map<String, String> parameters) throws URISyntaxException {

        URIBuilder uriBuilder = new URIBuilder();

        uriBuilder.setScheme("http").setHost(hostname).setPort(Integer.valueOf(port)).setPath(path);

        if(parameters == null) {
            return uriBuilder.build();
        }

        for(Map.Entry<String, String> thisParameter : parameters.entrySet()) {
            uriBuilder.setParameter(thisParameter.getKey(), thisParameter.getValue());
        }

        return uriBuilder.build();

    }

    public <T> T getResponse(HttpEntity httpEntity, Class<T> clazz) throws IOException {

        InputStream inputStream = httpEntity.getContent();

        return ObjectBuilder.build(inputStream, clazz);

    }
    
}
