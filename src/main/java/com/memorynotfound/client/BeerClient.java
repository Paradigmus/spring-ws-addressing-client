package com.memorynotfound.client;

import com.memorynotfound.beer.*;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.addressing.client.ActionCallback;
import org.springframework.ws.soap.addressing.core.EndpointReference;

import java.net.URI;
import java.net.URISyntaxException;

public class BeerClient extends WebServiceGatewaySupport {
    private static final String REPLY_TO = "http://localhost:8082/response";
    private static final String FAULT_TO = "http://localhost:8082/fault";

    public void sendGetBeerRequest(Integer id) throws URISyntaxException {
        GetBeerRequest request = new GetBeerRequest();
        request.setId(id);

        ActionCallback callback = new ActionCallback(
                new URI("http://memorynotfound.com/getBeerRequest"));
        callback.setReplyTo(new EndpointReference(
                new URI(REPLY_TO)));
        callback.setFaultTo(new EndpointReference(
                new URI(FAULT_TO)));

        getWebServiceTemplate().marshalSendAndReceive(request, callback);
    }
}