package com.memorynotfound.client;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

@Configuration
public class SoapClientConfig {
    private static final String DESTINATION_URL = "http://localhost:8080/ws/beers";

    @Bean
    public Jaxb2Marshaller marshaller() {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        marshaller.setContextPath("com.memorynotfound.beer");
        return marshaller;
    }

    @Bean
    public BeerClient beerClient(Jaxb2Marshaller marshaller) {
        BeerClient client = new BeerClient();
        client.setDefaultUri(DESTINATION_URL);
        client.setMarshaller(marshaller);
        client.setUnmarshaller(marshaller);
        return client;
    }

}
