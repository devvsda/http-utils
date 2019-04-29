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

    public static Protocol getProtocol(String protocol) {

        if ("https".equalsIgnoreCase(protocol)){
            return Protocol.HTTPS;
        } else if ("http".equalsIgnoreCase(protocol)) {
            return Protocol.HTTP;
        } else {
            throw new IllegalArgumentException(String.format("Wrong protocol value : %s", protocol));
        }
    }

    @Override
    public String toString() {
        return this.protocol;
    }


}
