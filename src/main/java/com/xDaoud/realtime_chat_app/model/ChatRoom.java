package com.xDaoud.realtime_chat_app.model;

import java.util.HashSet;
import java.util.Set;

public class ChatRoom {
    private long id;
    private String name;
    private RoomType roomType;
    private Set<User> users;

    public enum RoomType {
        DIRECT, GROUP, CHANNEL
    }

    public ChatRoom(String name, RoomType roomType, Set<User> users) {
        this.name = name;
        this.roomType = roomType;
        this.users = users;
    }
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public RoomType getRoomType() {
        return roomType;
    }
    public void setRoomType(RoomType roomType) {
        this.roomType = roomType;
    }
    public Set<User> getUsers() {
        return new HashSet<>(users);
    }
    public void setUsers(Set<User> users) {
        this.users = users;
    }
}
