package com.aws.carddemo.repository;

import com.aws.carddemo.model.entity.Csdat01Y;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Csdat01YRepository extends JpaRepository<Csdat01Y, Object> {
}
