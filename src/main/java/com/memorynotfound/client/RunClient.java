package com.memorynotfound.client;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import java.net.URISyntaxException;

public class RunClient {

    public static void main(String[] args) throws URISyntaxException {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SoapClientConfig.class);
        BeerClient client = context.getBean(BeerClient.class);

        switch (args.length){
            case 0:{
                client.sendGetBeerRequest(1);
                client.sendGetBeerRequest(0);
                break;
            }
            case 1:{
                String url = args[0];
                client.setDefaultUri(url);
                client.sendGetBeerRequest(1);
                client.sendGetBeerRequest(0);
                break;
            }
            case 3:{
                String url = args[0];
                String replyTo = args[1];
                String faultTo = args[2];
                client.setDefaultUri(url);
                client.sendGetBeerRequest(1, replyTo, faultTo);
                client.sendGetBeerRequest(0, replyTo, faultTo);
                break;
            }
            default:{
                System.out.println("Usage: java -jar client.jar $DESTINATION_URL");
                System.out.println("OR: java -jar client.jar $DESTINATION_URL $REPLY_TO_URL $FAULT_TO_URL");
                System.out.println("DEFAULT REPLY_TO: http://localhost:8082/response");
                System.out.println("DEFAULT FAULT_TO: http://localhost:8082/fault");
            }
        }
    }

}
