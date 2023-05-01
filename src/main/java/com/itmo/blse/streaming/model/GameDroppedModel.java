package com.itmo.blse.streaming.model;

import lombok.*;

import java.util.UUID;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GameDroppedModel {
    private UUID publicId;
}
