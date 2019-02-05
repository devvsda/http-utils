package com.devsda.utils.httputils.constants;

public enum Protocol {

    HTTPS("https"),
    HTTP("http");

    private String protocol;

    Protocol(String protocol) {
        this.protocol = protocol;
    }

    public String getProtocol() {
        return protocol;
    }
}
