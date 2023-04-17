package com.itmo.blse.repository;

import com.itmo.blse.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User getUserById(Long id);
}
