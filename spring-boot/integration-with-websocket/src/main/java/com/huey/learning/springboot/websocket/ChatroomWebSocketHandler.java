package com.huey.learning.springboot.websocket;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author huey
 */
@Slf4j
public class ChatroomWebSocketHandler extends TextWebSocketHandler {

    private final Set<WebSocketSession> wsSessions = ConcurrentHashMap.newKeySet();

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {

        String sessionId = session.getId();
        log.info("建立新的会话连接，会话ID：{}", sessionId);

        for (WebSocketSession wsSession : wsSessions) {
            wsSession.sendMessage(new TextMessage(sessionId + " 进入了聊天室。"));
        }
        wsSessions.add(session);

    }

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {

        for (WebSocketSession wsSession : wsSessions) {
            wsSession.sendMessage(new TextMessage(session.getId() + ": " + message.getPayload()));
        }

    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {

        String sessionId = session.getId();
        log.info("关闭会话连接，会话ID：{}", sessionId);

        wsSessions.remove(session);
        for (WebSocketSession wsSession : wsSessions) {
            wsSession.sendMessage(new TextMessage(session.getId() + " 离开了聊天室。"));
        }

    }

}