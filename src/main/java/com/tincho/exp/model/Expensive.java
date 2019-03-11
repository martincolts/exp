package com.tincho.exp.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.Date;

@Data
@Document(collection = "expensives")
public class Expensive implements Serializable {

    @Id
    private String id;
    private String description;
    private Date date;
    private Double amount;

}
