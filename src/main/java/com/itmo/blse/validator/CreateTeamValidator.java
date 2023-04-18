package com.itmo.blse.validator;

import com.itmo.blse.errors.ValidationError;
import com.itmo.blse.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

;

@Service
public class CreateTeamValidator {

    @Autowired
    TeamRepository teamRepository;


    public void clean(String name) throws ValidationError {

        List<String> errors = new ArrayList<>();
        if (teamRepository.getTeamByName(name) != null)
            errors.add(String.format("Team with name %s already exists", name));

        if (errors.size() != 0){
            throw new ValidationError(errors);
        }
    }
}
