package com.itmo.blse.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "tournament")
public class Tournament extends Timestamped{


    @Column(unique = true, nullable = false)
    private String name;

    @Column(nullable = false)
    private Date start_date;

    @Column(nullable = false)
    private int maxJudges;

}