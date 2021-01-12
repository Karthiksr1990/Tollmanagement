package com.tollmanagement.model;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.util.Date;

@Builder
@ToString
@Getter
public class Metric {
    private String boothId;
    private int countOfPass;
    private double amountCollected;
    private Date date;
}
