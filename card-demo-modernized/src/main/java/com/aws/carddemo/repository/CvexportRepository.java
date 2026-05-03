package com.aws.carddemo.repository;

import com.aws.carddemo.model.entity.Cvexport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CvexportRepository extends JpaRepository<Cvexport, Object> {
}
