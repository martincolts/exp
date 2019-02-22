package com.tincho.exp.services.base;

import com.tincho.exp.ExpensiveDTO;
import com.tincho.exp.services.Expensive;
import com.tincho.exp.repositories.ExpensiveRepository;
import com.tincho.exp.services.ExpensiveService;
import ma.glasnost.orika.MapperFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class ExpensiveServiceBase implements ExpensiveService {

    @Autowired
    private ExpensiveRepository expensiveRepository;

    @Autowired
    private MapperFacade mapperFacade;

    @Override
    public Mono<ExpensiveDTO> saveExpensive(ExpensiveDTO expensiveDTO) {
        Mono<Expensive> expensiveMono = expensiveRepository.save(mapperFacade.map(expensiveDTO, Expensive.class));
        Expensive expensive = expensiveMono.block();
        return Mono.just(mapperFacade.map(expensive, ExpensiveDTO.class));
    }
}
