# spring-ws-addressing-client

Application is sending SOAP requests with WS-Addressing (http://localhost:8082/response and http://localhost:8082/fault) to http://localhost:8080/ws/beers

One to reponse. Another to fault.

Launch with default values:
```java -jar client-1.1.0-jar-with-dependencies.jar```

Launch with custom destination_url:
```java -jar client-1.1.0-jar-with-dependencies.jar http://localhost:8080/ws/beers```

Launch with custom destionation_url, reply_to, fault_to:

```java -jar client-1.1.0-jar-with-dependencies.jar http://localhost:8080/ws/beers http://localhost:8082/response http://localhost:8082/fault```
