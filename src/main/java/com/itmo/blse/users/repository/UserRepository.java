package com.itmo.blse.users.repository;

import com.itmo.blse.tournaments.model.Roles;
import com.itmo.blse.users.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User getUserById(Long id);
    User getUserByUsername(String username);
    List<User> getAllByIdIn(List<Long> ids);
    List<User> getAllByRolesContains(Roles role);
}
