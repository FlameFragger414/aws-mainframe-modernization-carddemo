package com.aws.carddemo.service.impl;

import com.aws.carddemo.model.entity.Csutldwy;
import com.aws.carddemo.repository.CsutldwyRepository;
import com.aws.carddemo.service.CsutldwyService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CsutldwyServiceImpl implements CsutldwyService {
    private final CsutldwyRepository repository;

    @Override
    public Csutldwy save(Csutldwy entity) {
        return repository.save(entity);
    }

    @Override
    public Csutldwy findById(Object id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<Csutldwy> findAll() {
        return repository.findAll();
    }

    @Override
    public void deleteById(Object id) {
        repository.deleteById(id);
    }
}
