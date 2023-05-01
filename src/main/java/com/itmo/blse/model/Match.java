package com.itmo.blse.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.UUID;

@Getter
@Entity
@Setter
@NoArgsConstructor
public class Match {
    @Id
    UUID id;

    @ManyToOne
    Team team1;

    @ManyToOne
    Team team2;

    @ManyToOne
    Team winner;
}
