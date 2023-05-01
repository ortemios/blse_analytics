package com.itmo.blse.streaming.model;

import lombok.*;

import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TeamCreatedModel {
    private UUID publicId;
    private String name;
}
