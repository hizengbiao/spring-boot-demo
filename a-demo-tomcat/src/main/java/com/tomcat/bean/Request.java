package com.tomcat.bean;

public class Request {
    private String method;
    private String url;
    private String protocol;

    public Request(String method, String url, String protocol) {
        this.method = method;
        this.url = url;
        this.protocol = protocol;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getProtocol() {
        return protocol;
    }

    public void setProtocol(String protocol) {
        this.protocol = protocol;
    }
}
