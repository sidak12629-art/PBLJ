package com.example.transaction;

public interface BankService {
    void transfer(int fromId, int toId, double amount);
}
