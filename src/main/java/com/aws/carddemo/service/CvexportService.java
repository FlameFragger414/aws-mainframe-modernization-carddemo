package com.aws.carddemo.service;

import com.aws.carddemo.model.entity.Cvexport;
import java.util.List;

public interface CvexportService {
    Cvexport save(Cvexport entity);
    Cvexport findById(Object id);
    List<Cvexport> findAll();
    void deleteById(Object id);
}
