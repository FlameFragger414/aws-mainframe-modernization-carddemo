package com.aws.carddemo.service.impl;

import com.aws.carddemo.model.entity.Cvact02Y;
import com.aws.carddemo.repository.Cvact02YRepository;
import com.aws.carddemo.service.Cvact02YService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class Cvact02YServiceImpl implements Cvact02YService {
    private final Cvact02YRepository repository;

    @Override
    public Cvact02Y save(Cvact02Y entity) {
        return repository.save(entity);
    }

    @Override
    public Cvact02Y findById(Object id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<Cvact02Y> findAll() {
        return repository.findAll();
    }

    @Override
    public void deleteById(Object id) {
        repository.deleteById(id);
    }
}
