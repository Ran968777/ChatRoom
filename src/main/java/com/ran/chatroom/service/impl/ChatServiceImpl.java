package com.ran.chatroom.service.impl;

import com.ran.chatroom.service.ChatService;
import org.slf4j.Logger;
import org.springframework.stereotype.Service;

import java.util.*;

import static org.slf4j.LoggerFactory.getLogger;

/**
 * 描述:
 *
 * @author Ran
 * @create 2021-02-26 9:37
 */
@Service
public class ChatServiceImpl implements ChatService {
    private final static Logger LOG = getLogger(ChatServiceImpl.class);

    private static Map<String, HashSet> room = new HashMap();

    static {

    }

    @Override
    public void connect(String roomId, String userId) {
        if (!room.containsKey(roomId)) {
            room.put(roomId, new HashSet());
        }
        HashSet userIds = room.get(roomId);
        LOG.info("当前聊天室的成员有: "+ userIds);
        userIds.add(userId);
        LOG.info(userId+ " 加入成功！");
    }

    @Override
    public void disconnect(String roomId, String userId) {
        if (!room.containsKey(roomId)) {
            LOG.error("当前房间号不存在");
            return;
        }
        HashSet userIds = room.get(roomId);
        if (!userIds.contains(userId)){
            LOG.error("该房间下没有该用户");
            return;
        }
        userIds.remove(userId);
        LOG.info(userId+" 退出成功！！");
        LOG.info("当前聊天室的成员有: "+userIds);
    }
}