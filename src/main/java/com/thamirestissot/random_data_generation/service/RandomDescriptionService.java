package com.thamirestissot.random_data_generation.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class RandomDescriptionService {
    @Value("${randomWords}")
    private String ramdomWords;

    public String create(long key) {
        String description = new String();
        int beginning = (key > ramdomWords.length()) ? 13 : (int) key;
        for (int i = beginning; i < ramdomWords.length(); i++) {
            description += ramdomWords.charAt(i);
        }
        return ramdomWords;
    }
}