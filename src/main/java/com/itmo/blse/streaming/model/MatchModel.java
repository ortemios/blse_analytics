package com.itmo.blse.streaming.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MatchModel {
    UUID publicId;
    UUID team1PublicId;
    UUID team2PublicId;
}
