package com.itmo.blse.repository;

import com.itmo.blse.model.Team;
import com.itmo.blse.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface TeamRepository extends JpaRepository<Team, Long> {

    Team getTeamById(Long id);
    List<Team> getAllByIdIn(List<Long> ids);
}
