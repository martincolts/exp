package com.tincho.exp.services.base;

import com.tincho.exp.dtos.ExpensiveDTO;
import com.tincho.exp.repositories.ExpensiveRepository;
import com.tincho.exp.model.Expensive;
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
        Expensive expensive = mapperFacade.map(expensiveDTO, Expensive.class);
        return expensiveRepository.save(expensive)
                .map(p -> mapperFacade.map(p, ExpensiveDTO.class))
                .flatMap(e -> Mono.just(e));
    }

}
