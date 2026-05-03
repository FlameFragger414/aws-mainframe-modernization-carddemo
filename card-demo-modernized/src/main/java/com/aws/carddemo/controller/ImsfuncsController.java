package com.aws.carddemo.controller;

import com.aws.carddemo.model.entity.Imsfuncs;
import com.aws.carddemo.service.ImsfuncsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1/imsfuncs")
@RequiredArgsConstructor
public class ImsfuncsController {
    private final ImsfuncsService service;

    @PostMapping
    public ResponseEntity<Imsfuncs> create(@RequestBody Imsfuncs entity) {
        return ResponseEntity.ok(service.save(entity));
    }

    @GetMapping
    public ResponseEntity<List<Imsfuncs>> getAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Imsfuncs> getById(@PathVariable Object id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Object id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
