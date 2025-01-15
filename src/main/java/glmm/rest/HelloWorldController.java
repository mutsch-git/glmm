package glmm.rest;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
public class HelloWorldController 
{
    @Value("${coach.name}")
    private String coachName;

    @Value("${team.name}")
    private String teamName;

    @GetMapping("/hello-world")
    public String getHello() 
    {
        return "Hello World from trainer " + this.coachName + " and team " + this.teamName;
    }
}