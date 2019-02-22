package com.tincho.exp.services;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@Document
public class Expensive {

    @Id
    private Long id;
    private String description;
    private Date date;
    private Double amount;

}
