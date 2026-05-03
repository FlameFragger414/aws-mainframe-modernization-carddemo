package com.aws.carddemo.controller;

import com.aws.carddemo.model.entity.Unused1Y;
import com.aws.carddemo.service.Unused1YService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1/unused1y")
@RequiredArgsConstructor
public class Unused1YController {
    private final Unused1YService service;

    @PostMapping
    public ResponseEntity<Unused1Y> create(@RequestBody Unused1Y entity) {
        return ResponseEntity.ok(service.save(entity));
    }

    @GetMapping
    public ResponseEntity<List<Unused1Y>> getAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Unused1Y> getById(@PathVariable Object id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Object id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
