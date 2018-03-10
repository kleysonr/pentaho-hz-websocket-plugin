package com.krios.pentaho.plugin.classic.hzwebsocket.services;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import com.google.gson.Gson;

public class MessagingWebSocketHandler extends TextWebSocketHandler {
	
	/*
	List<WebSocketSession> sessions = new CopyOnWriteArrayList<>();

	@Override
	public void handleTextMessage(WebSocketSession session, TextMessage message)
			throws InterruptedException, IOException {
		
		for(WebSocketSession webSocketSession : sessions) {
			Map value = new Gson().fromJson(message.getPayload(), Map.class);
			webSocketSession.sendMessage(new TextMessage("Hello " + value.get("name") + " !"));
		}
	}

	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		//the messages will be broadcasted to all users.
		sessions.add(session);
	}
	*/
	
    @Override
    public void handleTransportError(WebSocketSession session, Throwable throwable) throws Exception {
        System.out.println("********************** error occured at sender " + session + throwable);
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
    	System.out.println(String.format("********************** Session %s closed because of %s", session.getId(), status.getReason()));
    }

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
    	System.out.println("********************** Connected ... " + session.getId());
    }

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage jsonTextMessage) throws Exception {
    	System.out.println("********************** message received: " + jsonTextMessage.getPayload());
    }	

}
