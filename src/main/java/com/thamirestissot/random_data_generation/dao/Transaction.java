package com.thamirestissot.random_data_generation.dao;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Transaction {
    @JsonProperty("descricao")
    private String description;
    @JsonProperty("data")
    private Long date;
    @JsonProperty("valor")
    private long value;
    @JsonProperty("duplicated")
    private boolean duplicated;

    public Transaction(String description, Long date, long value, boolean duplicated) {
        this.description = description;
        this.date = date;
        this.value = value;
        this.duplicated = duplicated;
    }

    public Transaction createCopy(boolean duplicated) {
        return new Transaction(this.description, this.date, this.value, duplicated);
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getDate() {
        return date;
    }

    public void setDate(Long date) {
        this.date = date;
    }

    public long getValue() {
        return value;
    }

    public void setValue(long value) {
        this.value = value;
    }

    public boolean isDuplicated() {
        return duplicated;
    }

    public void setDuplicated(boolean duplicated) {
        this.duplicated = duplicated;
    }
}