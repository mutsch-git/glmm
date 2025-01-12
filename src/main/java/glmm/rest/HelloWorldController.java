package glmm.rest;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
public class HelloWorldController {


    @GetMapping("/hello-world")
    public String getHello() 
    {
        return "Hello World";
    }

}