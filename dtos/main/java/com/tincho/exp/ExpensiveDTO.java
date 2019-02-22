package com.tincho.exp;

import lombok.Data;

import java.util.Date;

@Data
public class ExpensiveDTO {

    private String description;
    private Date date;
    private Double amount;

}
