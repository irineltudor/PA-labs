package com.lab10.Commands.communicationobjects;

import java.io.Serializable;

public class Response implements Serializable {
    private String message;
    private com.lab10.Commands.CommunicationObjects.Cookie cookie;

    public Response(String message, com.lab10.Commands.CommunicationObjects.Cookie cookie) {
        this.message = message;
        this.cookie = cookie;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public com.lab10.Commands.CommunicationObjects.Cookie getCookie() {
        return cookie;
    }

    public void setCookie(com.lab10.Commands.CommunicationObjects.Cookie cookie) {
        this.cookie = cookie;
    }
}
