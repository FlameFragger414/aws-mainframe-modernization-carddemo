package com.aws.carddemo.service.impl;

import com.aws.carddemo.model.entity.Cvact03Y;
import com.aws.carddemo.repository.Cvact03YRepository;
import com.aws.carddemo.service.Cvact03YService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class Cvact03YServiceImpl implements Cvact03YService {
    private final Cvact03YRepository repository;

    @Override
    public Cvact03Y save(Cvact03Y entity) {
        return repository.save(entity);
    }

    @Override
    public Cvact03Y findById(Object id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<Cvact03Y> findAll() {
        return repository.findAll();
    }

    @Override
    public void deleteById(Object id) {
        repository.deleteById(id);
    }
}
