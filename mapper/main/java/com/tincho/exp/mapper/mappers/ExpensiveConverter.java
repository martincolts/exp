package com.tincho.exp.mapper.mappers;

import com.tincho.exp.ExpensiveDTO;
import com.tincho.exp.services.Expensive;
import ma.glasnost.orika.CustomMapper;
import ma.glasnost.orika.MappingContext;
import org.springframework.stereotype.Component;

@Component
public class ExpensiveConverter extends CustomMapper<Expensive, ExpensiveDTO> {

    @Override
    public void mapAtoB(Expensive expensive, ExpensiveDTO expensiveDTO, MappingContext context) {
        expensiveDTO.setDescription(expensive.getDescription());
        expensiveDTO.setDate(expensive.getDate());
        expensiveDTO.setAmount(expensive.getAmount());
    }

    @Override
    public void mapBtoA(ExpensiveDTO expensiveDTO, Expensive expensive, MappingContext context) {
        expensive.setAmount(expensiveDTO.getAmount());
        expensive.setDate(expensive.getDate());
        expensive.setDescription(expensive.getDescription());
    }
}
