package com.itmo.blse.service;


import com.itmo.blse.model.Tournament;
import com.itmo.blse.repository.TournamentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TournamentReader {

    @Autowired
    TournamentRepository tournamentRepository;

    public List<Tournament> getAll(){
        return tournamentRepository.findAll();
    }

    public Tournament getById(Long id){
        return tournamentRepository.getTournamentById(id);
    }
}
