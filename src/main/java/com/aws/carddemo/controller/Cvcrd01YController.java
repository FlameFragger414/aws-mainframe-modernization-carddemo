package com.aws.carddemo.controller;

import com.aws.carddemo.model.entity.Cvcrd01Y;
import com.aws.carddemo.service.Cvcrd01YService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1/cvcrd01y")
@RequiredArgsConstructor
public class Cvcrd01YController {
    private final Cvcrd01YService service;

    @PostMapping
    public ResponseEntity<Cvcrd01Y> create(@RequestBody Cvcrd01Y entity) {
        return ResponseEntity.ok(service.save(entity));
    }

    @GetMapping
    public ResponseEntity<List<Cvcrd01Y>> getAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cvcrd01Y> getById(@PathVariable Object id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Object id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
