package com.aws.carddemo.service;

import com.aws.carddemo.model.entity.Ccpaurqy;
import java.util.List;

public interface CcpaurqyService {
    Ccpaurqy save(Ccpaurqy entity);
    Ccpaurqy findById(Object id);
    List<Ccpaurqy> findAll();
    void deleteById(Object id);
}
