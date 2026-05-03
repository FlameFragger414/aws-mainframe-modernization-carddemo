package com.aws.carddemo.repository;

import com.aws.carddemo.model.entity.Ccpauery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CcpaueryRepository extends JpaRepository<Ccpauery, Object> {
}
