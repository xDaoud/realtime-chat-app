package com.xDaoud.realtime_chat_app.repository;

import com.xDaoud.realtime_chat_app.model.ChatMessage;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ChatMessageRepository extends JpaRepository<ChatMessage, Long> {
    List<ChatMessage> findByChatRoomIdOrderById(Long chatRoomId);
    ChatMessage save(ChatMessage chatMessage);
}
