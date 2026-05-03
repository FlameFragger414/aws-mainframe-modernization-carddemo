package com.aws.carddemo.service.impl;

import com.aws.carddemo.model.entity.Cvact01Y;
import com.aws.carddemo.repository.Cvact01YRepository;
import com.aws.carddemo.service.Cvact01YService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class Cvact01YServiceImpl implements Cvact01YService {
    private final Cvact01YRepository repository;

    @Override
    public Cvact01Y save(Cvact01Y entity) {
        return repository.save(entity);
    }

    @Override
    public Cvact01Y findById(Object id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<Cvact01Y> findAll() {
        return repository.findAll();
    }

    @Override
    public void deleteById(Object id) {
        repository.deleteById(id);
    }
}
