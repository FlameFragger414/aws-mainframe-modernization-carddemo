package com.aws.carddemo.service.impl;

import com.aws.carddemo.model.entity.Cvtra01Y;
import com.aws.carddemo.repository.Cvtra01YRepository;
import com.aws.carddemo.service.Cvtra01YService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class Cvtra01YServiceImpl implements Cvtra01YService {
    private final Cvtra01YRepository repository;

    @Override
    public Cvtra01Y save(Cvtra01Y entity) {
        return repository.save(entity);
    }

    @Override
    public Cvtra01Y findById(Object id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<Cvtra01Y> findAll() {
        return repository.findAll();
    }

    @Override
    public void deleteById(Object id) {
        repository.deleteById(id);
    }
}
