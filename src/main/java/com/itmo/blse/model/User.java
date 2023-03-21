package com.itmo.blse.model;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

@Table
public class User {
    @Id
    Long id;
    @Column(nullable = false)
    String username;
}
