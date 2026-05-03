package com.aws.carddemo.repository;

import com.aws.carddemo.model.entity.Imsfuncs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImsfuncsRepository extends JpaRepository<Imsfuncs, Object> {
}
