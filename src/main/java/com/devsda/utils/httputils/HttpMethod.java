package com.devsda.utils.httputils;

import java.net.URL;
import java.util.Map;

public interface HttpMethod {

    void call(String hostname, String port, Map<String, String> headers, Map<String, Object> body);

    void call(URL url, Map<String, String> headers, Map<String, Object> body);
    
}
