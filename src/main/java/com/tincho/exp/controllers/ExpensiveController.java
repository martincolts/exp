package com.tincho.exp.controllers;

import com.tincho.exp.dtos.ExpensiveDTO;
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
    @ResponseBody public Mono<ExpensiveDTO> saveExpensive(@RequestBody ExpensiveDTO expensiveDTO){
        return expensiveService.saveExpensive(expensiveDTO);
    }
}
