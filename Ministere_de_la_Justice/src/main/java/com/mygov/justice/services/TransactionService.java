package com.mygov.justice.services;

import com.mygov.justice.dto.TransactionRequest;
import com.mygov.justice.entyties.Transaction;
import com.mygov.justice.repositories.TransactionRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;

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
