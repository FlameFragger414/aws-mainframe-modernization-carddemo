package com.aws.carddemo.repository;

import com.aws.carddemo.model.entity.Cottl01Y;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Cottl01YRepository extends JpaRepository<Cottl01Y, Object> {
}
