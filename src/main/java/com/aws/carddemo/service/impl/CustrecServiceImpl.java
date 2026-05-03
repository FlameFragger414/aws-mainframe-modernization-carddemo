package com.aws.carddemo.service.impl;

import com.aws.carddemo.model.entity.Custrec;
import com.aws.carddemo.repository.CustrecRepository;
import com.aws.carddemo.service.CustrecService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CustrecServiceImpl implements CustrecService {
    private final CustrecRepository repository;

    @Override
    public Custrec save(Custrec entity) {
        return repository.save(entity);
    }

    @Override
    public Custrec findById(Object id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<Custrec> findAll() {
        return repository.findAll();
    }

    @Override
    public void deleteById(Object id) {
        repository.deleteById(id);
    }
}
