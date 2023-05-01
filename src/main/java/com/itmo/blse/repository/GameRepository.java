package com.itmo.blse.repository;

import com.itmo.blse.model.Game;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface GameRepository extends JpaRepository<Game, UUID> {

    Game getGameById(UUID id);
}
