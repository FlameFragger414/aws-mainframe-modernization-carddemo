package com.aws.carddemo.controller;

import com.aws.carddemo.model.entity.Csdat01Y;
import com.aws.carddemo.service.Csdat01YService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1/csdat01y")
@RequiredArgsConstructor
public class Csdat01YController {
    private final Csdat01YService service;

    @PostMapping
    public ResponseEntity<Csdat01Y> create(@RequestBody Csdat01Y entity) {
        return ResponseEntity.ok(service.save(entity));
    }

    @GetMapping
    public ResponseEntity<List<Csdat01Y>> getAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Csdat01Y> getById(@PathVariable Object id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Object id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
