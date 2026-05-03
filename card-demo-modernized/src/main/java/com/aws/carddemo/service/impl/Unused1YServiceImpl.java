package com.aws.carddemo.service.impl;

import com.aws.carddemo.model.entity.Unused1Y;
import com.aws.carddemo.repository.Unused1YRepository;
import com.aws.carddemo.service.Unused1YService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class Unused1YServiceImpl implements Unused1YService {
    private final Unused1YRepository repository;

    @Override
    public Unused1Y save(Unused1Y entity) {
        return repository.save(entity);
    }

    @Override
    public Unused1Y findById(Object id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<Unused1Y> findAll() {
        return repository.findAll();
    }

    @Override
    public void deleteById(Object id) {
        repository.deleteById(id);
    }
}
