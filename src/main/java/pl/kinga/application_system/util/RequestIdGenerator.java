package pl.kinga.application_system.util;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@Scope("prototype")
public class RequestIdGenerator {

    private final String requestId;

    public RequestIdGenerator(){
        this.requestId = UUID.randomUUID().toString().substring(0, 8);
    }

    @PostConstruct
    public void init(){
        System.out.println("New RequestIdGenerator: " + requestId);
    }

    public String getRequestId(){
         return requestId;
    }
}
