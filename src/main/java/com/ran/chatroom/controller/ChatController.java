package com.ran.chatroom.controller;

import com.ran.chatroom.service.ChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 描述:
 *
 * @author Ran
 * @create 2021-02-26 9:30
 */
@RestController("/chatroom")
public class ChatController {

    @Autowired
    ChatService chatService;

    @GetMapping("/connect")
    public void connect(String roomId, String userId) {
        chatService.connect(roomId, userId);
    }

    @GetMapping("/disconnect")
    public void disconnect(String roomId, String userId) {
        chatService.disconnect(roomId, userId);
    }
}