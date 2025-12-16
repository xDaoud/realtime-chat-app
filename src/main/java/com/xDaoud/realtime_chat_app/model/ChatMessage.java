package com.xDaoud.realtime_chat_app.model;

import jakarta.persistence.*;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;

@Entity
public class ChatMessage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String content;
    @ManyToOne
    private User senderUser;
    @ManyToOne
    @JoinColumn(nullable = true)
    private ChatRoom chatRoom;
    private MessageType messageType;
    @Column(nullable = false)
    @CreatedDate
    private LocalDateTime createdAt;

    public enum MessageType {
        CHAT, JOIN, LEAVE
    }

    public ChatMessage() {
        this.createdAt = LocalDateTime.now();
    }
    public ChatMessage( String content, MessageType type) {
        this.content = content;
        this.messageType = type;
        this.createdAt = LocalDateTime.now();
    }
    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
    }

    public MessageType getMessageType() {
        return messageType;
    }
    public void setMessageType(MessageType messageType) {
        this.messageType = messageType;
    }
    public ChatRoom getChatRoom() {
        return chatRoom;
    }
    public void setChatRoom(ChatRoom chatRoom) {
        this.chatRoom = chatRoom;
    }
    public User getSenderUser() {
        return senderUser;
    }
    public void setSenderUser(User senderUser) {
        this.senderUser = senderUser;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
