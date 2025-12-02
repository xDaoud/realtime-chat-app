package com.xDaoud.realtime_chat_app.model;

import jakarta.persistence.*;

@Entity
public class ChatMessage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String content;
    @ManyToOne
    private User senderUser;
    @ManyToOne
    private ChatRoom chatRoom;
    private MessageType messageType;

    public enum MessageType {
        CHAT, JOIN, LEAVE
    }

    public ChatMessage() {
    }
    public ChatMessage( String content, MessageType type) {
        this.content = content;
        this.messageType = type;
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
}
