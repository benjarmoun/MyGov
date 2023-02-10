package com.mygov.finance.services;

import com.mygov.finance.dto.TransactionRequest;
import com.mygov.finance.entyties.Transaction;
import com.mygov.finance.repositories.TransactionRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@AllArgsConstructor
public class TransactionService {


    private final TransactionRepository transactionRepository;

    public void addTransaction(TransactionRequest request){
        Transaction transaction = Transaction.builder()
                .nom(request.nom())
                .ministere(request.ministere())
                .description(request.description())
                .date(LocalDate.now())
                .build();

        transactionRepository.saveAndFlush(transaction);
    }
}
