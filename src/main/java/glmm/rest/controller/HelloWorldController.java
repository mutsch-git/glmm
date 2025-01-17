package glmm.rest.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@RestController
@RequestMapping
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