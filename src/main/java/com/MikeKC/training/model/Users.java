package com.MikeKC.training.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
public class Users {

    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private String teamName;
    private Integer salary;
}
