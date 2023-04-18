package com.itmo.blse.model;


import javax.persistence.Table;

@Table
public enum UserRole {
    USER,
    MODERATOR,
    JUDGE
}
