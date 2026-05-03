package com.aws.carddemo.controller;

import com.aws.carddemo.model.entity.Cvcus01Y;
import com.aws.carddemo.service.Cvcus01YService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1/cvcus01y")
@RequiredArgsConstructor
public class Cvcus01YController {
    private final Cvcus01YService service;

    @PostMapping
    public ResponseEntity<Cvcus01Y> create(@RequestBody Cvcus01Y entity) {
        return ResponseEntity.ok(service.save(entity));
    }

    @GetMapping
    public ResponseEntity<List<Cvcus01Y>> getAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cvcus01Y> getById(@PathVariable Object id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Object id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
