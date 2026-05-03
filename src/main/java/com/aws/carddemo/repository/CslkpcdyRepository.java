package com.aws.carddemo.repository;

import com.aws.carddemo.model.entity.Cslkpcdy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CslkpcdyRepository extends JpaRepository<Cslkpcdy, Object> {
}
