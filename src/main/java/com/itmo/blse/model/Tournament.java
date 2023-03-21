package com.itmo.blse.model;

import java.util.List;

public class Tournament {
    Long id;
    int maxReferees;
    String name;

    List<Match> matches;
    List<User> referees;
}
