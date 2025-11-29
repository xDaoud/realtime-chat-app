package com.xDaoud.realtime_chat_app.controller;

import com.xDaoud.realtime_chat_app.model.ChatMessage;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ChatController {

    @MessageMapping("/char.sendMessage")
    @SendTo("/public/topic")
    public ChatMessage sendMessage(ChatMessage chatMessage) {
        return chatMessage;
    }

    @RequestMapping("/chat.addUser")
    @SendTo("/public/topic")
    public ChatMessage addUser(ChatMessage chatMessage) {
        chatMessage.setMessageType(ChatMessage.MessageType.JOIN);
        return chatMessage;
    }
}
