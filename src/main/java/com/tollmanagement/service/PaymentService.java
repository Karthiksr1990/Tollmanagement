package com.tollmanagement.service;

import com.tollmanagement.model.Pass;

public interface PaymentService {

    void payment(Pass pass, double amount);
}
