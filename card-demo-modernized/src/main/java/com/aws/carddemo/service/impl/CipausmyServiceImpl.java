package com.aws.carddemo.service.impl;

import com.aws.carddemo.model.entity.Cipausmy;
import com.aws.carddemo.repository.CipausmyRepository;
import com.aws.carddemo.service.CipausmyService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CipausmyServiceImpl implements CipausmyService {
    private final CipausmyRepository repository;

    @Override
    public Cipausmy save(Cipausmy entity) {
        return repository.save(entity);
    }

    @Override
    public Cipausmy findById(Object id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<Cipausmy> findAll() {
        return repository.findAll();
    }

    @Override
    public void deleteById(Object id) {
        repository.deleteById(id);
    }
}
