package com.tollmanagement.dao.inmemory.impl;

import com.tollmanagement.dao.inmemory.PaymentDao;
import com.tollmanagement.model.BoothDTO;
import com.tollmanagement.model.Pass;
import com.tollmanagement.model.Payment;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public class PaymentDaoImpl implements PaymentDao {

    private List<Payment> paymentsLog = new ArrayList<>();

    @Override
    public void payment(Pass pass, double amount) {
        List<BoothDTO> boothDTOS = new ArrayList<>(pass.getBooths());
        paymentsLog.add(Payment.builder().amount(amount).paymentId(UUID.randomUUID().toString())
                .pass(pass).paymentBoothId(boothDTOS.get(0).getBooth().getBoothId()).date(new Date()).build());
    }
}
