package com.itmo.blse.model;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name="analytics_streaming_error")
public class StreamingError {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition="TEXT")
    private String message;

    @Column(columnDefinition="TEXT")
    private String errorText;

    @Column
    private String eventId;

    @Column
    private String eventAction;
}
