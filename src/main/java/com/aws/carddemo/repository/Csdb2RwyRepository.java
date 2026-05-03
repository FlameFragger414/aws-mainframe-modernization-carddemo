package com.aws.carddemo.repository;

import com.aws.carddemo.model.entity.Csdb2Rwy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Csdb2RwyRepository extends JpaRepository<Csdb2Rwy, Object> {
}
