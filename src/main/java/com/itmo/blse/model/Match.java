package com.itmo.blse.model;


import lombok.*;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "matches")
public class Match {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "team1_id")
    private Team team1;

    @ManyToOne
    @JoinColumn(name = "team2_id")
    private Team team2;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "tournament_id", nullable = false )
    private Tournament tournament;

    @ManyToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "next_match_id")
    private Match nextMatch;

}
