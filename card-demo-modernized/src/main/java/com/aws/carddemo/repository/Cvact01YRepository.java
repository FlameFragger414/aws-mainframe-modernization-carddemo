package com.aws.carddemo.repository;

import com.aws.carddemo.model.entity.Cvact01Y;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Cvact01YRepository extends JpaRepository<Cvact01Y, Object> {
}
