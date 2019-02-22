package com.tincho.exp.repositories;

import com.tincho.exp.services.Expensive;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ExpensiveRepository extends ReactiveMongoRepository<Expensive, Long> {

    Mono<Expensive> save(Expensive expensive);
    Flux<Expensive> findAll();
}
