package com.aws.carddemo.controller;

import com.aws.carddemo.model.entity.Cvtra03Y;
import com.aws.carddemo.service.Cvtra03YService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1/cvtra03y")
@RequiredArgsConstructor
public class Cvtra03YController {
    private final Cvtra03YService service;

    @PostMapping
    public ResponseEntity<Cvtra03Y> create(@RequestBody Cvtra03Y entity) {
        return ResponseEntity.ok(service.save(entity));
    }

    @GetMapping
    public ResponseEntity<List<Cvtra03Y>> getAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cvtra03Y> getById(@PathVariable Object id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Object id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
