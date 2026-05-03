package com.aws.carddemo.service.impl;

import com.aws.carddemo.model.entity.Cipaudty;
import com.aws.carddemo.repository.CipaudtyRepository;
import com.aws.carddemo.service.CipaudtyService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CipaudtyServiceImpl implements CipaudtyService {
    private final CipaudtyRepository repository;

    @Override
    public Cipaudty save(Cipaudty entity) {
        return repository.save(entity);
    }

    @Override
    public Cipaudty findById(Object id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<Cipaudty> findAll() {
        return repository.findAll();
    }

    @Override
    public void deleteById(Object id) {
        repository.deleteById(id);
    }
}
