package com.xDaoud.realtime_chat_app.model;


public class User {
    private long id;
    private String username;
    private String sessionId;

    public  User(String username, String sessionId) {
        this.username = username;
        this.sessionId = sessionId;
    }
    public User() {
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getSessionId() {
        return sessionId;
    }
    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
}
