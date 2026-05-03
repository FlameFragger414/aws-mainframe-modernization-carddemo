package com.aws.carddemo.service.impl;

import com.aws.carddemo.model.entity.Cottl01Y;
import com.aws.carddemo.repository.Cottl01YRepository;
import com.aws.carddemo.service.Cottl01YService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class Cottl01YServiceImpl implements Cottl01YService {
    private final Cottl01YRepository repository;

    @Override
    public Cottl01Y save(Cottl01Y entity) {
        return repository.save(entity);
    }

    @Override
    public Cottl01Y findById(Object id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<Cottl01Y> findAll() {
        return repository.findAll();
    }

    @Override
    public void deleteById(Object id) {
        repository.deleteById(id);
    }
}
