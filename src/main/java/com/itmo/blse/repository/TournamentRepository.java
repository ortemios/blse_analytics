package com.itmo.blse.repository;

import com.itmo.blse.model.Team;
import com.itmo.blse.model.Tournament;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface TournamentRepository extends JpaRepository<Tournament, UUID> {

    Tournament getTournamentById(UUID id);
}
