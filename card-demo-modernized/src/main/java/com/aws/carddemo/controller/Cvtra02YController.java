package com.aws.carddemo.controller;

import com.aws.carddemo.model.entity.Cvtra02Y;
import com.aws.carddemo.service.Cvtra02YService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1/cvtra02y")
@RequiredArgsConstructor
public class Cvtra02YController {
    private final Cvtra02YService service;

    @PostMapping
    public ResponseEntity<Cvtra02Y> create(@RequestBody Cvtra02Y entity) {
        return ResponseEntity.ok(service.save(entity));
    }

    @GetMapping
    public ResponseEntity<List<Cvtra02Y>> getAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cvtra02Y> getById(@PathVariable Object id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Object id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
