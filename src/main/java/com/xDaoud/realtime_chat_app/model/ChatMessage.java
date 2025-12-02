package com.xDaoud.realtime_chat_app.model;


public class ChatMessage {
    private Long id;
    private String content;
    private User senderUser;
    private User receiverUser;
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
