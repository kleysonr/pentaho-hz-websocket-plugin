package com.krios.pentaho.plugin.classic.hzwebsocket.services;

import java.io.IOException;

import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

import org.springframework.web.socket.server.standard.SpringConfigurator;


@ServerEndpoint(value = "/ws", configurator = SpringConfigurator.class)
public class Websocket {
	
	public Websocket() {
		System.out.println("---------------------- Inicializando Websocket");
	}
  
	@OnOpen
	public void onOpen(Session session) {
		System.out.println("onOpen::" + session.getId());        
	}
  
	@OnClose
	public void onClose(Session session) {
		System.out.println("onClose::" +  session.getId());
	}
  
	@OnMessage
	public void onMessage(String message, Session session) {
		System.out.println("onMessage::From=" + session.getId() + " Message=" + message);
      
		try {
			session.getBasicRemote().sendText("Hello Client " + session.getId() + "!");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
  
	@OnError
	public void onError(Throwable t) {
		System.out.println("onError::" + t.getMessage());
	}

}