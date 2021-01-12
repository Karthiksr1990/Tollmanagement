package com.tollmanagement.service.impl;

import com.tollmanagement.dao.inmemory.PaymentDao;
import com.tollmanagement.model.BoothDTO;
import com.tollmanagement.model.Pass;
import com.tollmanagement.model.Payment;
import com.tollmanagement.service.PaymentService;
import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@AllArgsConstructor
public class PaymentServiceImpl implements PaymentService {

    PaymentDao paymentDao;
    private LeaderBoardService leaderBoardService;

    @Override
    public void payment(Pass pass, double amount) {
        List<BoothDTO> boothDTOS = new ArrayList<>(pass.getBooths());
        paymentDao.payment(pass, amount);
        leaderBoardService.collectStats(Payment.builder().
                amount(amount).date(new Date()).pass(pass).paymentBoothId(boothDTOS.get(0).getBooth().getBoothId()).build());

    }
}
