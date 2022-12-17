package com.example.demo.controller;

import com.example.demo.dto.PersonDTO;
import com.example.demo.dto.ResultDTO;
import com.example.demo.model.Person;
import com.example.demo.service.DrawService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@CrossOrigin
public class MainController {

    @Autowired
    DrawService drawService;

    @PostMapping("/draw")
    public ResultDTO draw(@RequestBody PersonDTO personDTO)
    {
        return drawService.drawPerson(personDTO);
    }

    @GetMapping("/list")
    public List<Person> list(){
        return drawService.getList();
    }

    @GetMapping("/fix")
    public void fix(){
         drawService.fix();
    }

}
