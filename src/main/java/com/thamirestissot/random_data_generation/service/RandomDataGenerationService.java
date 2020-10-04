package com.thamirestissot.random_data_generation.service;

import com.thamirestissot.random_data_generation.dao.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class RandomDataGenerationService {
    private final int changeKey = 3;
    @Autowired
    private RandomDescriptionService randomDescriptionService;

    public List<Transaction> generate(Long id, int year, int month) {

        LocalDateTime date = LocalDateTime.of(year, month, 1, 0, 0);
        List<Transaction> transactions = new ArrayList<Transaction>();
        boolean duplicated;

        for (int key = 1; key <= month; key++) {
            duplicated = willBeDuplicated(key);

            Transaction transaction = createTransaction(date.plusDays(key * 2), id, duplicated);
            transactions.add(transaction);
            if (duplicated) {
                transactions.add(transaction.createCopy(false));
            }
        }
        return transactions;
    }

    private Transaction createTransaction(LocalDateTime baseDate, Long id, boolean duplicated) {
        long key = id * changeKey;

        String description = randomDescriptionService.create(key);

        Timestamp date = Timestamp.valueOf(baseDate);

        return new Transaction(description, date.getTime(), key * 100, duplicated);
    }

    private boolean willBeDuplicated(int key) {
        return key % 2 == 0;
    }
}