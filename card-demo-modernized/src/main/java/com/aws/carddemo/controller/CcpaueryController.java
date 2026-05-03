package com.aws.carddemo.controller;

import com.aws.carddemo.model.entity.Ccpauery;
import com.aws.carddemo.service.CcpaueryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1/ccpauery")
@RequiredArgsConstructor
public class CcpaueryController {
    private final CcpaueryService service;

    @PostMapping
    public ResponseEntity<Ccpauery> create(@RequestBody Ccpauery entity) {
        return ResponseEntity.ok(service.save(entity));
    }

    @GetMapping
    public ResponseEntity<List<Ccpauery>> getAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Ccpauery> getById(@PathVariable Object id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Object id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
