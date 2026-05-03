package com.aws.carddemo.repository;

import com.aws.carddemo.model.entity.Codatecn;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CodatecnRepository extends JpaRepository<Codatecn, Object> {
}
