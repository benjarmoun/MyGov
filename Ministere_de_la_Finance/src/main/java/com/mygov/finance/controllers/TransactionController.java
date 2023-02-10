package com.mygov.finance.controllers;

import com.mygov.finance.dto.TransactionRequest;
import com.mygov.finance.services.TransactionService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("transaction")
@AllArgsConstructor
public class TransactionController {

    private final TransactionService transactionService;
    @PostMapping
    public void registerCustomer(@RequestBody TransactionRequest transactionRequest) {
//        log.info("new transaction registration {}", transactionRequest);
        transactionService.addTransaction(transactionRequest);
    }
}
