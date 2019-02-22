package com.tincho.exp;

import com.tincho.exp.services.ExpensiveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/expensives")
public class ExpensiveController {

    @Autowired
    private ExpensiveService expensiveService;

    @RequestMapping(method = RequestMethod.POST)
    public Mono<ExpensiveDTO> saveExpensive(@RequestBody ExpensiveDTO expensiveDTO){
        return expensiveService.saveExpensive(expensiveDTO);
    }
}
