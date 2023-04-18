package com.itmo.blse.model;

import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tournament")
public class Tournament extends Timestamped{


    @Column(unique = true, nullable = false)
    private String name;

    @Column(nullable = false)
    private Date startDate;

    @Column(nullable = false)
    private int maxJudges;

    @Column
    private double approvalRatio;

    @Column
    private int maxGames;

    @ManyToMany
    private List<User> judges;

    @ManyToMany
    private List<Team> teams;


}