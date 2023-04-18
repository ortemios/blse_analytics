package com.itmo.blse.model;

import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

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

    @ManyToMany
    List<User> judges;

    @ManyToMany
    List<Team> teams;

    //@OneToMany(mappedBy = "tournament", fetch = FetchType.EAGER)
    //List<Match> matches;


}