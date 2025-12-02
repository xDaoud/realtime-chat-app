package com.xDaoud.realtime_chat_app.repository;

import com.xDaoud.realtime_chat_app.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
    User findBySessionId(String sessionId);
}
