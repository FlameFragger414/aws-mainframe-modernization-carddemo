package com.aws.carddemo.repository;

import com.aws.carddemo.model.entity.Coadm02Y;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Coadm02YRepository extends JpaRepository<Coadm02Y, Object> {
}
