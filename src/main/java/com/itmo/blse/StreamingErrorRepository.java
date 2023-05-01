package com.itmo.blse;


import com.itmo.blse.model.StreamingError;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StreamingErrorRepository extends JpaRepository<StreamingError, Long> {


}
