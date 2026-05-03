package com.aws.carddemo.service.impl;

import com.aws.carddemo.model.entity.Cvtra02Y;
import com.aws.carddemo.repository.Cvtra02YRepository;
import com.aws.carddemo.service.Cvtra02YService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class Cvtra02YServiceImpl implements Cvtra02YService {
    private final Cvtra02YRepository repository;

    @Override
    public Cvtra02Y save(Cvtra02Y entity) {
        return repository.save(entity);
    }

    @Override
    public Cvtra02Y findById(Object id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<Cvtra02Y> findAll() {
        return repository.findAll();
    }

    @Override
    public void deleteById(Object id) {
        repository.deleteById(id);
    }
}
