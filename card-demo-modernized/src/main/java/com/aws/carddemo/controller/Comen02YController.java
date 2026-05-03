package com.aws.carddemo.controller;

import com.aws.carddemo.model.entity.Comen02Y;
import com.aws.carddemo.service.Comen02YService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1/comen02y")
@RequiredArgsConstructor
public class Comen02YController {
    private final Comen02YService service;

    @PostMapping
    public ResponseEntity<Comen02Y> create(@RequestBody Comen02Y entity) {
        return ResponseEntity.ok(service.save(entity));
    }

    @GetMapping
    public ResponseEntity<List<Comen02Y>> getAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Comen02Y> getById(@PathVariable Object id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Object id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
