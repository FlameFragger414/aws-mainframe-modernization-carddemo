package com.aws.carddemo.controller;

import com.aws.carddemo.model.entity.Ccpaurly;
import com.aws.carddemo.service.CcpaurlyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1/ccpaurly")
@RequiredArgsConstructor
public class CcpaurlyController {
    private final CcpaurlyService service;

    @PostMapping
    public ResponseEntity<Ccpaurly> create(@RequestBody Ccpaurly entity) {
        return ResponseEntity.ok(service.save(entity));
    }

    @GetMapping
    public ResponseEntity<List<Ccpaurly>> getAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Ccpaurly> getById(@PathVariable Object id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Object id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
