package com.tincho.exp.controllers;

import com.tincho.exp.controller.ExpensiveDTO;
import com.tincho.exp.model.Expensive;
import com.tincho.exp.services.ExpensiveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/expensives")
public class ExpensiveController {

    @Autowired
    private ExpensiveService expensiveService;

    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody public Mono<ExpensiveDTO> saveExpensive(@RequestBody Expensive expensive){
        return expensiveService.saveExpensive(expensive);
    }
}
