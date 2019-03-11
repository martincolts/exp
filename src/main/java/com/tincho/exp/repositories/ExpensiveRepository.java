package com.tincho.exp.repositories;


import com.tincho.exp.model.Expensive;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface ExpensiveRepository extends ReactiveMongoRepository<Expensive, String> {
    Mono<Expensive> save (Expensive expensive);
}
