package com.tollmanagement.model;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.util.Date;

@Builder
@ToString
@Getter
public class Payment {
    private Pass pass;
    private double amount;
    private String paymentId;
    private Date date;
    private String paymentBoothId;
}
