package com.aws.carddemo.controller;

import com.aws.carddemo.model.entity.Csdb2Rwy;
import com.aws.carddemo.service.Csdb2RwyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1/csdb2rwy")
@RequiredArgsConstructor
public class Csdb2RwyController {
    private final Csdb2RwyService service;

    @PostMapping
    public ResponseEntity<Csdb2Rwy> create(@RequestBody Csdb2Rwy entity) {
        return ResponseEntity.ok(service.save(entity));
    }

    @GetMapping
    public ResponseEntity<List<Csdb2Rwy>> getAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Csdb2Rwy> getById(@PathVariable Object id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Object id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
