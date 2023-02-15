package com.mygov.finance.controllers;

import com.mygov.finance.dto.TransactionRequest;
import com.mygov.finance.services.TransactionService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("fin/transaction")
@AllArgsConstructor
public class TransactionController {

    private final TransactionService transactionService;
    @PostMapping
    public ResponseEntity registerCustomer(@RequestBody TransactionRequest transactionRequest) {
//        log.info("new transaction registration {}", transactionRequest);
        transactionService.addTransaction(transactionRequest);
        return ResponseEntity.ok().body("done");
    }

    @GetMapping
    ResponseEntity get(){
        return ResponseEntity.ok().body("Finance ministry");
    }
}
