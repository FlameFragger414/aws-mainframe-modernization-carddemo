package com.aws.carddemo.repository;

import com.aws.carddemo.model.entity.Csusr01Y;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Csusr01YRepository extends JpaRepository<Csusr01Y, Object> {
}
