package com.memorynotfound.client;

import org.springframework.ws.client.WebServiceClientException;
import org.springframework.ws.client.support.interceptor.ClientInterceptor;
import org.springframework.ws.context.MessageContext;
import org.springframework.ws.transport.context.TransportContext;
import org.springframework.ws.transport.context.TransportContextHolder;
import org.springframework.ws.transport.http.HttpComponentsConnection;
import org.springframework.ws.transport.http.HttpUrlConnection;

import java.io.IOException;

public class AddHttpHeaderInterceptor implements ClientInterceptor {

    public boolean handleFault(MessageContext messageContext) throws WebServiceClientException {
        return true;
    }

    @Override
    public void afterCompletion(MessageContext messageContext, Exception e) throws WebServiceClientException {

    }

    public boolean handleRequest(MessageContext messageContext) throws WebServiceClientException {
        TransportContext context = TransportContextHolder.getTransportContext();
        HttpUrlConnection connection = (HttpUrlConnection) context.getConnection();
        try {
            connection.addRequestHeader("Host", "host-example.com");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return true;
    }

    public boolean handleResponse(MessageContext messageContext) throws WebServiceClientException {
        return true;
    }

}