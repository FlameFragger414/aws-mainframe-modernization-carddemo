package com.aws.carddemo.service.impl;

import com.aws.carddemo.model.entity.Comen02Y;
import com.aws.carddemo.repository.Comen02YRepository;
import com.aws.carddemo.service.Comen02YService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class Comen02YServiceImpl implements Comen02YService {
    private final Comen02YRepository repository;

    @Override
    public Comen02Y save(Comen02Y entity) {
        return repository.save(entity);
    }

    @Override
    public Comen02Y findById(Object id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<Comen02Y> findAll() {
        return repository.findAll();
    }

    @Override
    public void deleteById(Object id) {
        repository.deleteById(id);
    }
}
