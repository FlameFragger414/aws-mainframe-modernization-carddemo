package com.aws.carddemo.repository;

import com.aws.carddemo.model.entity.Cvcus01Y;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Cvcus01YRepository extends JpaRepository<Cvcus01Y, Object> {
}
