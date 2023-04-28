package com.itmo.blse.users.model;

import com.itmo.blse.tournaments.model.Roles;
import com.itmo.blse.app.model.Timestamped;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "users")
public class User extends Timestamped {

    @Column(unique = true, nullable = false)
    private String username;

    @ElementCollection(fetch = FetchType.EAGER)
    @Enumerated(EnumType.STRING)
    private List<Roles> roles = new ArrayList<>();

    public boolean hasRole(Roles role){
        return roles.contains(role);
    }

}

