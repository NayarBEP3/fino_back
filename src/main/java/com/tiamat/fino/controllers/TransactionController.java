package com.tiamat.fino.controllers;

import com.tiamat.fino.dtos.transactions.AddTransactionDto;
import com.tiamat.fino.dtos.transactions.TransactionDto;
import com.tiamat.fino.services.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/transaction")
public class TransactionController {

    private final TransactionService transactionService;

    public TransactionController(@Autowired TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @PostMapping
    public TransactionDto transactionDto(@RequestBody AddTransactionDto addTransactionDto) {
        return transactionService.createTransaction(addTransactionDto);
    }

    @GetMapping(path = "/{id}")
    public TransactionDto transactionDto(@PathVariable String id) {
        return transactionService.getTransactionById(id);
    }
}
