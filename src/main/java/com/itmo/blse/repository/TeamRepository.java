package com.itmo.blse.repository;

import com.itmo.blse.model.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface TeamRepository extends JpaRepository<Team, UUID> {

    Team getTeamByPublicId(UUID id);

    List<Team> findAllByPublicIdIn(List<UUID> ids);
}
