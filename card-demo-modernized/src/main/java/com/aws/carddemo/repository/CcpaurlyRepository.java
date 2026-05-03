package com.aws.carddemo.repository;

import com.aws.carddemo.model.entity.Ccpaurly;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CcpaurlyRepository extends JpaRepository<Ccpaurly, Object> {
}
