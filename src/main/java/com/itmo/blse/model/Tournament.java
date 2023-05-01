package com.itmo.blse.model;

import com.itmo.blse.streaming.model.MatchCreatedModel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Tournament {
    @Id
    UUID id;
    String name;
    Date startedAt;
    @OneToMany
    List<Team> teams;
    @OneToMany
    List<Match> matches;
}
