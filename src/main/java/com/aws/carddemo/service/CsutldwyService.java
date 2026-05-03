package com.aws.carddemo.service;

import com.aws.carddemo.model.entity.Csutldwy;
import java.util.List;

public interface CsutldwyService {
    Csutldwy save(Csutldwy entity);
    Csutldwy findById(Object id);
    List<Csutldwy> findAll();
    void deleteById(Object id);
}
