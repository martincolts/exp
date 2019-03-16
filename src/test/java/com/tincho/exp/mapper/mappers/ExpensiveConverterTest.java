package com.tincho.exp.mapper.mappers;

import com.tincho.exp.dtos.ExpensiveDTO;
import com.tincho.exp.model.Expensive;
import org.easymock.TestSubject;

import java.util.Date;
import java.util.GregorianCalendar;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class ExpensiveConverterTest extends ConverterTest<Expensive, ExpensiveDTO> {

    public static final String DESCRIPTION = "Description";
    public static final Date DATE = new GregorianCalendar(2000, 6, 6).getTime();
    public static final double AMOUNT = 20.6;
    public static final String ID = "5c8d759d4c3d1d0b6c8e69f9";

    @TestSubject
    private ExpensiveConverter expensiveConverter = new ExpensiveConverter();

    @Override
    public Expensive generateA() {
        Expensive expensive = new Expensive();
        expensive.setDescription(DESCRIPTION);
        expensive.setDate(DATE);
        expensive.setAmount(AMOUNT);
        expensive.setId(ID);
        return expensive;
    }

    @Override
    public ExpensiveDTO generateB() {
        ExpensiveDTO expensiveDTO = new ExpensiveDTO();
        expensiveDTO.setDescription(DESCRIPTION);
        expensiveDTO.setDate(DATE);
        expensiveDTO.setAmount(AMOUNT);
        expensiveDTO.setId(ID);
        return expensiveDTO;
    }

    public void mapAtoBTest() {
        Expensive expensive = generateA();
        ExpensiveDTO expensiveDTO = new ExpensiveDTO();
        expensiveConverter.mapAtoB(expensive, expensiveDTO, null);
        assertThat(expensiveDTO.getAmount(), is(equalTo(AMOUNT)));
        assertThat(expensiveDTO.getDate(), is(equalTo(DATE)));
        assertThat(expensiveDTO.getDescription(), is(equalTo(DESCRIPTION)));
        assertThat(expensiveDTO.getId(), is(equalTo(ID)));
    }

    public void mapBtoATest() {
        ExpensiveDTO expensiveDTO = generateB();
        Expensive expensive = new Expensive();
        expensiveConverter.mapBtoA(expensiveDTO, expensive, null);
        assertThat(expensive.getAmount(), is(equalTo(AMOUNT)));
        assertThat(expensive.getDate(), is(equalTo(DATE)));
        assertThat(expensive.getDescription(), is(equalTo(DESCRIPTION)));
        assertThat(expensive.getId(), is(equalTo(ID)));
    }

}
