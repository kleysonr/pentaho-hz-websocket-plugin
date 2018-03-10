package com.krios.pentaho.plugin.classic.hzwebsocket.services;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.client.standard.WebSocketContainerFactoryBean;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

@Configuration
@EnableWebSocket
public class WebSocketConfig implements WebSocketConfigurer {
    @Bean
    public WebSocketHandler webSocketHandler() {
        //handler of your websocket. should be a class implementing WebSocketHandler.
        //You could also extend AbstractWebSocketHandler or TextWebSocketHandler and override methods
        return new MessagingWebSocketHandler(); 
    }

    /*
    @Bean
    public WebSocketContainerFactoryBean createWebSocketContainer() {
        WebSocketContainerFactoryBean container = new WebSocketContainerFactoryBean();
        //container.setsetMaxTextMessageBufferSize(2048000);
        //container.setMaxBinaryMessageBufferSize(2048000);
        //container.setMaxSessionIdleTimeout(StaticConfig.MAXIMUM_WS_SESSION_IDLE_TIMEOUT);
        //container.setAsyncSendTimeout(StaticConfig.MAXIMUM_WS_ASYNC_SEND_TIMEOUT);
        return container;
    }
    */

    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry webSocketHandlerRegistry) {
    	System.out.println("*************************************** Registering Handler");
        webSocketHandlerRegistry.addHandler(webSocketHandler(), "/ws").setAllowedOrigins("*").withSockJS();; // you could also get handler from context 
    }

}
