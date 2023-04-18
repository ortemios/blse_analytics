package com.itmo.blse.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name = "team")
public class Team extends Timestamped{

    @Column(unique = true, nullable = false)
    private String name;

}