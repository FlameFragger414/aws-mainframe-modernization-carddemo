package com.aws.carddemo.service.impl;

import com.aws.carddemo.model.entity.Cvcrd01Y;
import com.aws.carddemo.repository.Cvcrd01YRepository;
import com.aws.carddemo.service.Cvcrd01YService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class Cvcrd01YServiceImpl implements Cvcrd01YService {
    private final Cvcrd01YRepository repository;

    @Override
    public Cvcrd01Y save(Cvcrd01Y entity) {
        return repository.save(entity);
    }

    @Override
    public Cvcrd01Y findById(Object id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<Cvcrd01Y> findAll() {
        return repository.findAll();
    }

    @Override
    public void deleteById(Object id) {
        repository.deleteById(id);
    }
}
