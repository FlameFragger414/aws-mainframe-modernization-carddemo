package com.aws.carddemo.controller;

import com.aws.carddemo.model.entity.Cvtra01Y;
import com.aws.carddemo.service.Cvtra01YService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1/cvtra01y")
@RequiredArgsConstructor
public class Cvtra01YController {
    private final Cvtra01YService service;

    @PostMapping
    public ResponseEntity<Cvtra01Y> create(@RequestBody Cvtra01Y entity) {
        return ResponseEntity.ok(service.save(entity));
    }

    @GetMapping
    public ResponseEntity<List<Cvtra01Y>> getAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cvtra01Y> getById(@PathVariable Object id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Object id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
