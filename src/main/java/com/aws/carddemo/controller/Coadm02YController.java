package com.aws.carddemo.controller;

import com.aws.carddemo.model.entity.Coadm02Y;
import com.aws.carddemo.service.Coadm02YService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1/coadm02y")
@RequiredArgsConstructor
public class Coadm02YController {
    private final Coadm02YService service;

    @PostMapping
    public ResponseEntity<Coadm02Y> create(@RequestBody Coadm02Y entity) {
        return ResponseEntity.ok(service.save(entity));
    }

    @GetMapping
    public ResponseEntity<List<Coadm02Y>> getAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Coadm02Y> getById(@PathVariable Object id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Object id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
