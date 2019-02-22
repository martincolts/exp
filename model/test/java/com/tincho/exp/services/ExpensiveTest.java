package com.tincho.exp.services;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

@RunWith(SpringRunner.class)
public class ExpensiveTest {

    private static final Date DATE = new Date(2010, 4, 5);
    private static final String DESCRIPTION = "DESCRIPTION";
    private static final double AMOUNT = 20.5;
    private static final Long ID = 1L;

    @Test
    public void createModel() {
        Expensive expensive = new Expensive();
        expensive.setAmount(AMOUNT);
        expensive.setDate(DATE);
        expensive.setDescription(DESCRIPTION);
        expensive.setId(ID);
        assertThat(expensive.getAmount(), is(equalTo(AMOUNT)));
        assertThat(expensive.getDate(), is(equalTo(DATE)));
        assertThat(expensive.getDescription(), is(equalTo(DESCRIPTION)));
        assertThat(expensive.getId(), is(equalTo(ID)));
    }
}
