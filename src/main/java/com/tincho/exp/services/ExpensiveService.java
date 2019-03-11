package com.tincho.exp.services;

import com.tincho.exp.controller.ExpensiveDTO;
import com.tincho.exp.model.Expensive;
import reactor.core.publisher.Mono;

public interface ExpensiveService {


    Mono<ExpensiveDTO> saveExpensive(Expensive expensive);
}
