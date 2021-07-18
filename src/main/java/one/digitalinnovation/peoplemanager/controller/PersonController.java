package one.digitalinnovation.peoplemanager.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//Defines the callable http address for this object:
@RestController
@RequestMapping("/api/v1/people")
public class PersonController {
    @GetMapping
    public String getBook(){
        return "API Test!";
    }
}