package com.aws.carddemo.repository;

import com.aws.carddemo.model.entity.Csmsg01Y;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Csmsg01YRepository extends JpaRepository<Csmsg01Y, Object> {
}
