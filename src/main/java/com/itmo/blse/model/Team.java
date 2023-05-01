package com.itmo.blse.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.UUID;

@Entity(name="analytics_team")
@Getter
@Setter
@NoArgsConstructor
public class Team {

    @Id
    private UUID id;

    @Column
    String name;
}
