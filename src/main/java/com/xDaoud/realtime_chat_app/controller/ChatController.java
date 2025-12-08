package com.xDaoud.realtime_chat_app.controller;

import com.xDaoud.realtime_chat_app.model.ChatMessage;
import com.xDaoud.realtime_chat_app.model.ChatRoom;
import com.xDaoud.realtime_chat_app.model.User;
import com.xDaoud.realtime_chat_app.repository.ChatMessageRepository;
import com.xDaoud.realtime_chat_app.repository.ChatRoomRepository;
import com.xDaoud.realtime_chat_app.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ChatController {

    private final ChatMessageRepository chatMessageRepository;
    //private final SimpMessagingTemplate simpMessagingTemplate;
    private final UserRepository userRepository;
    private final ChatRoomRepository chatRoomRepository;

    public ChatController(ChatMessageRepository chatMessageRepository, UserRepository userRepository, ChatRoomRepository chatRoomRepository) {
        this.chatMessageRepository = chatMessageRepository;
        this.userRepository = userRepository;
        this.chatRoomRepository = chatRoomRepository;
    }

    @MessageMapping("/chat.sendMessage")
    @SendTo("/topic/public")
    @Transactional
    public ChatMessage sendMessage(ChatMessage chatMessage,
                                   SimpMessageHeaderAccessor headerAccessor) {

        String sessionId = headerAccessor.getSessionId();

        User sender = userRepository.findBySessionId(sessionId);

        if (sender == null) {
            // Create and save new user
            sender = new User("Unknown", sessionId);
            sender = userRepository.save(sender);
        }

        chatMessage.setId(null);
        chatMessage.setSenderUser(sender);

        chatMessage.setMessageType(ChatMessage.MessageType.CHAT);

        ChatRoom defaultRoom = chatRoomRepository.findByName("General");
        if (defaultRoom == null) {
            defaultRoom = new ChatRoom("General");
            defaultRoom = chatRoomRepository.save(defaultRoom);
        }
        chatMessage.setChatRoom(defaultRoom);

        return chatMessageRepository.save(chatMessage);
    }

    @MessageMapping("/chat.addUser")
    @SendTo("/topic/public")
    @Transactional
    public ChatMessage addUser(ChatMessage chatMessage,
                               SimpMessageHeaderAccessor headerAccessor) {

        String sessionId = headerAccessor.getSessionId();
        String username = chatMessage.getContent().replace(" joined", "");

        User user = userRepository.findByUsername(username);
        if (user == null) {
            user = new User(username, sessionId);
        } else {
            user.setSessionId(sessionId);
        }
        userRepository.save(user);

        ChatMessage joinMessage = new ChatMessage();
        joinMessage.setContent(username + " joined");
        joinMessage.setMessageType(ChatMessage.MessageType.JOIN);
        joinMessage.setSenderUser(user);

        return chatMessageRepository.save(joinMessage);
    }
}
