package com.tincho.exp.mapper.mappers;

import com.tincho.exp.dtos.ExpensiveDTO;
import com.tincho.exp.model.Expensive;
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
        expensiveDTO.setId(expensive.getId());
    }

    @Override
    public void mapBtoA(ExpensiveDTO expensiveDTO, Expensive expensive, MappingContext context) {
        expensive.setAmount(expensiveDTO.getAmount());
        expensive.setDate(expensiveDTO.getDate());
        expensive.setDescription(expensiveDTO.getDescription());
        expensive.setId(expensiveDTO.getId());
    }
}
