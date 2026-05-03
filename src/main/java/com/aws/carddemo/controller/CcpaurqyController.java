package com.aws.carddemo.controller;

import com.aws.carddemo.model.entity.Ccpaurqy;
import com.aws.carddemo.service.CcpaurqyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1/ccpaurqy")
@RequiredArgsConstructor
public class CcpaurqyController {
    private final CcpaurqyService service;

    @PostMapping
    public ResponseEntity<Ccpaurqy> create(@RequestBody Ccpaurqy entity) {
        return ResponseEntity.ok(service.save(entity));
    }

    @GetMapping
    public ResponseEntity<List<Ccpaurqy>> getAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Ccpaurqy> getById(@PathVariable Object id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Object id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
