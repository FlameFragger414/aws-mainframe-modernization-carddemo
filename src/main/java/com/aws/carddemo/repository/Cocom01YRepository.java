package com.aws.carddemo.repository;

import com.aws.carddemo.model.entity.Cocom01Y;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Cocom01YRepository extends JpaRepository<Cocom01Y, Object> {
}
