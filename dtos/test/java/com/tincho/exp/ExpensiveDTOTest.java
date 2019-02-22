package com.tincho.exp;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

@RunWith(SpringRunner.class)
public class ExpensiveDTOTest {

    private static final Date DATE = new Date(2010, 4, 5);
    private static final String DESCRIPTION = "DESCRIPTION";
    private static final double AMOUNT = 20.5;

    @Test
    public void createDTO() {
        ExpensiveDTO expensiveDTO = new ExpensiveDTO();
        expensiveDTO.setAmount(AMOUNT);
        expensiveDTO.setDate(DATE);
        expensiveDTO.setDescription(DESCRIPTION);
        assertThat(expensiveDTO.getAmount(), is(equalTo(AMOUNT)));
        assertThat(expensiveDTO.getDate(), is(equalTo(DATE)));
        assertThat(expensiveDTO.getDescription(), is(equalTo(DESCRIPTION)));
    }
}
