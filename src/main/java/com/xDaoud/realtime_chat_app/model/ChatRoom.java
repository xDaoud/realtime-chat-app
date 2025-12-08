package com.xDaoud.realtime_chat_app.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class ChatRoom {
    @Id
    @GeneratedValue
    private long id;
    private String name;
    private RoomType roomType;
    @ManyToMany
    @JoinTable (
            name = "user_chat_rooms",
            joinColumns = @JoinColumn (name = "chat_room_id"),
            inverseJoinColumns = @JoinColumn (name = "user_id")
    )
    @JsonIgnore
    private Set<User> participants = new HashSet<>();

    public enum RoomType {
        DIRECT, GROUP, CHANNEL
    }

    public ChatRoom() {}

    public ChatRoom(String name, RoomType roomType, Set<User> users) {
        this.name = name;
        this.roomType = roomType;
        this.participants = users;
    }

    public ChatRoom(String name) {
        this.name = name;
        this.roomType = RoomType.DIRECT;
        this.participants = new HashSet<>();
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
    public Set<User> getParticipants() {
        return new HashSet<>(participants);
    }
    public void setParticipants(Set<User> participants) {
        this.participants = participants;
    }
}
