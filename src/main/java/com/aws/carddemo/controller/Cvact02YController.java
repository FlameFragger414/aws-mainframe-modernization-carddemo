package com.aws.carddemo.controller;

import com.aws.carddemo.model.entity.Cvact02Y;
import com.aws.carddemo.service.Cvact02YService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1/cvact02y")
@RequiredArgsConstructor
public class Cvact02YController {
    private final Cvact02YService service;

    @PostMapping
    public ResponseEntity<Cvact02Y> create(@RequestBody Cvact02Y entity) {
        return ResponseEntity.ok(service.save(entity));
    }

    @GetMapping
    public ResponseEntity<List<Cvact02Y>> getAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cvact02Y> getById(@PathVariable Object id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Object id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
