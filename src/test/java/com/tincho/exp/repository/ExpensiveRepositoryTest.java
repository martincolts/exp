package com.tincho.exp.repository;

import com.tincho.exp.MongoReactiveApplication;
import com.tincho.exp.model.Expensive;
import com.tincho.exp.repositories.ExpensiveRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.AutoConfigureDataMongo;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.aggregation.ArithmeticOperators;
import org.springframework.test.context.junit4.SpringRunner;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import java.util.Date;
import java.util.GregorianCalendar;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

@RunWith(SpringRunner.class)
@AutoConfigureDataMongo
@DataMongoTest
public class ExpensiveRepositoryTest {

    private static final String DESCRIPTION = "Description";
    private static final Date DATE = new GregorianCalendar(2018,5,6).getTime();
    private static final Double AMOUNT = 20.5;
    private static final String ID = "fd5sf89dsf89ds9f";
    @Autowired
    private ExpensiveRepository expensiveRepository;

    @Test
    public void saveTest(){
        Expensive expensive = new Expensive();
        expensive.setDescription(DESCRIPTION);
        expensive.setDate(DATE);
        expensive.setAmount(AMOUNT);
        expensive.setId(ID);
        Mono<Expensive> expensiveMono = expensiveRepository.save(expensive);
        StepVerifier.create(
                expensiveMono)
                .consumeNextWith(exp -> {
                    assertThat(exp.getAmount(), is(equalTo(AMOUNT)));
                    assertThat(exp.getDate(), is(equalTo(DATE)));
                    assertThat(exp.getDescription(), is(equalTo(DESCRIPTION)));
                    assertThat(exp.getId(), is(equalTo(ID)));
                })
                .verifyComplete();
    }
}
