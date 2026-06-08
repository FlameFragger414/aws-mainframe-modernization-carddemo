package com.aws.carddemo.controller;

import com.aws.carddemo.model.dto.TransactionDTO;
import com.aws.carddemo.model.entity.Transaction;
import com.aws.carddemo.service.TransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/transaction")
@RequiredArgsConstructor
public class TransactionController {
    private final TransactionService service;

    @PostMapping
    public ResponseEntity<Transaction> create(@RequestBody Transaction entity) {
        return ResponseEntity.ok(service.save(entity));
    }

    @PostMapping("/process")
    public ResponseEntity<Transaction> process(@RequestBody TransactionDTO dto) {
        return ResponseEntity.ok(service.processTransaction(dto));
    }

    @GetMapping
    public ResponseEntity<List<Transaction>> getAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Transaction> getById(@PathVariable String id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @GetMapping("/account/{accountId}")
    public ResponseEntity<List<Transaction>> getByAccount(@PathVariable Long accountId) {
        return ResponseEntity.ok(service.findByAccountId(accountId));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
