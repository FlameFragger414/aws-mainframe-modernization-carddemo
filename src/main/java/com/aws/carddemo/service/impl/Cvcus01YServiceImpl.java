package com.aws.carddemo.service.impl;

import com.aws.carddemo.model.entity.Cvcus01Y;
import com.aws.carddemo.repository.Cvcus01YRepository;
import com.aws.carddemo.service.Cvcus01YService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class Cvcus01YServiceImpl implements Cvcus01YService {
    private final Cvcus01YRepository repository;

    @Override
    public Cvcus01Y save(Cvcus01Y entity) {
        return repository.save(entity);
    }

    @Override
    public Cvcus01Y findById(Object id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<Cvcus01Y> findAll() {
        return repository.findAll();
    }

    @Override
    public void deleteById(Object id) {
        repository.deleteById(id);
    }
}
