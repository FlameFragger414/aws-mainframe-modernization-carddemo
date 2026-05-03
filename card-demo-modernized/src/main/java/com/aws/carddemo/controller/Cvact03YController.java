package com.aws.carddemo.controller;

import com.aws.carddemo.model.entity.Cvact03Y;
import com.aws.carddemo.service.Cvact03YService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1/cvact03y")
@RequiredArgsConstructor
public class Cvact03YController {
    private final Cvact03YService service;

    @PostMapping
    public ResponseEntity<Cvact03Y> create(@RequestBody Cvact03Y entity) {
        return ResponseEntity.ok(service.save(entity));
    }

    @GetMapping
    public ResponseEntity<List<Cvact03Y>> getAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cvact03Y> getById(@PathVariable Object id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Object id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
