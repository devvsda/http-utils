package com.devsda.utils.httputils.models;

public class HealthCheck {

    private String echoString;
    private String hostName;

    public String getEchoString() {
        return echoString;
    }

    public void setEchoString(String echoString) {
        this.echoString = echoString;
    }

    public String getHostName() {
        return hostName;
    }

    public void setHostName(String hostName) {
        this.hostName = hostName;
    }

    @Override
    public String toString() {
        return "HealthCheck{" +
                "echoString='" + echoString + '\'' +
                ", hostName='" + hostName + '\'' +
                '}';
    }
}
