package com.aws.carddemo.service.impl;

import com.aws.carddemo.model.entity.Ccpaurly;
import com.aws.carddemo.repository.CcpaurlyRepository;
import com.aws.carddemo.service.CcpaurlyService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CcpaurlyServiceImpl implements CcpaurlyService {
    private final CcpaurlyRepository repository;

    @Override
    public Ccpaurly save(Ccpaurly entity) {
        return repository.save(entity);
    }

    @Override
    public Ccpaurly findById(Object id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<Ccpaurly> findAll() {
        return repository.findAll();
    }

    @Override
    public void deleteById(Object id) {
        repository.deleteById(id);
    }
}
