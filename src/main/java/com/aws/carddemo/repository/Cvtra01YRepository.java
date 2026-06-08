package com.aws.carddemo.repository;

import com.aws.carddemo.model.entity.Cvtra01Y;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Cvtra01YRepository extends JpaRepository<Cvtra01Y, Object> {
    List<Cvtra01Y> findByTrancatAcctIdAndTrancatTypeCdAndTrancatCd(
            Long trancatAcctId, String trancatTypeCd, Integer trancatCd);
}
