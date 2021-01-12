package com.tollmanagement.dao.inmemory;

import com.tollmanagement.model.Pass;

public interface PaymentDao {
    void payment(Pass pass, double amount);
}
