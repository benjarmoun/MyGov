package com.mygov.justice.controllers;

import com.mygov.justice.dto.TransactionRequest;
import com.mygov.justice.entyties.Transaction;
import com.mygov.justice.services.TransactionService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;

@Slf4j
@RestController
@RequestMapping("jus/transaction")
@AllArgsConstructor
public record TransactionController(TransactionService transactionService, RestTemplate restTemplate) {

    @PostMapping
    ResponseEntity<String> registerCustomer(@RequestBody TransactionRequest request) {
//        log.info("new transaction registration {}", transactionRequest);
        transactionService.addTransaction(request);
        Transaction transaction = new Transaction();
        transaction.setNom(request.nom());
        transaction.setDescription(request.description());
        transaction.setMinistere(request.ministere());
        transaction.setDate(LocalDate.now());
        return ResponseEntity.ok().body(restTemplate.postForObject("http://FINANCE/fin/transaction", transaction, String.class));
    }

    @GetMapping
    ResponseEntity get(){
        return ResponseEntity.ok().body(restTemplate.getForObject("http://FINANCE/fin/transaction", String.class));
    }
}
