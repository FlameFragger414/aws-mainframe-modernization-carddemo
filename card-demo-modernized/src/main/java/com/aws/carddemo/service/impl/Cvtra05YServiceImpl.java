package com.aws.carddemo.service.impl;

import com.aws.carddemo.model.entity.Cvtra05Y;
import com.aws.carddemo.repository.Cvtra05YRepository;
import com.aws.carddemo.service.Cvtra05YService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class Cvtra05YServiceImpl implements Cvtra05YService {
    private final Cvtra05YRepository repository;

    @Override
    public Cvtra05Y save(Cvtra05Y entity) {
        return repository.save(entity);
    }

    @Override
    public Cvtra05Y findById(Object id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<Cvtra05Y> findAll() {
        return repository.findAll();
    }

    @Override
    public void deleteById(Object id) {
        repository.deleteById(id);
    }
}
