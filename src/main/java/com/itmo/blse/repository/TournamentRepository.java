package com.itmo.blse.repository;

import com.itmo.blse.model.Tournament;
import com.itmo.blse.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface TournamentRepository extends JpaRepository<Tournament, Long> {

    Tournament getTournamentById(@Param("id") Long id);



}
