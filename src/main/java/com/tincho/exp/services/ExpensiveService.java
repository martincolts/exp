package com.tincho.exp.services;

import com.tincho.exp.dtos.ExpensiveDTO;
import reactor.core.publisher.Mono;

public interface ExpensiveService {


    Mono<ExpensiveDTO> saveExpensive(ExpensiveDTO expensiveDTO);
}
