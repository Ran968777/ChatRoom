package com.ran.chatroom.service;

/**
 * 描述:
 *
 * @author Ran
 * @create 2021-02-26 9:37
 */
public interface ChatService {

    void connect(String roomId, String userId);

    void disconnect(String roomId, String userId);
}