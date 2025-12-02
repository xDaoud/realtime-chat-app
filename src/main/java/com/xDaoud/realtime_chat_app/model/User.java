package com.xDaoud.realtime_chat_app.model;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String username;
    private String sessionId;

    @ManyToMany(mappedBy = "participants")
    private Set<ChatRoom> chatRooms = new HashSet<>();

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
