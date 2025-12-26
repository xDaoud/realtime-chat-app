package com.xDaoud.realtime_chat_app.repository;

import com.xDaoud.realtime_chat_app.model.ChatRoom;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChatRoomRepository extends JpaRepository<ChatRoom, Long> {
    ChatRoom findByName(String name);

    default ChatRoom save(ChatRoom chatRoom) {
        return null;
    }
}
