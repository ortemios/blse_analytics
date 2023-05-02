package com.itmo.blse.repository;

import com.itmo.blse.model.Game;
import com.itmo.blse.model.Match;
import com.itmo.blse.model.Report;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ReportRepository extends JpaRepository<Report, Long> {

    Report findFirstByOrderByCreatedDesc();
}
