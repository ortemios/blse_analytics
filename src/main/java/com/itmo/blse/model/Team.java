package com.itmo.blse.model;

import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "team")
public class Team extends Timestamped{

    @Column(unique = true, nullable = false)
    private String name;

}