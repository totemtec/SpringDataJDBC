package com.example.sum;

import com.example.basic.Person;
import com.example.basic.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class StepController {

    @Autowired
    StepService stepService;

    @GetMapping("/step/count")
    public String stepCount()
    {
        stepService.printCount();
        return("success");
    }
}
