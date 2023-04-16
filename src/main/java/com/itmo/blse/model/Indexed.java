package com.itmo.blse.model;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.Id;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
@Getter
@Setter
public abstract class Indexed {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

}
