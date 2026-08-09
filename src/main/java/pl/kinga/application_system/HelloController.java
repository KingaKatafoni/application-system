package pl.kinga.application_system;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @GetMapping("/hello")
    public String hello(){
        return "System rejestracji wnioskow dziala!";
    }


    @GetMapping("/status")
    public String stat(){
        return "System wnioskow: AKTYWNY";
    }


}
