package com.aws.carddemo.repository;

import com.aws.carddemo.model.entity.Cvcrd01Y;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Cvcrd01YRepository extends JpaRepository<Cvcrd01Y, Object> {
}
