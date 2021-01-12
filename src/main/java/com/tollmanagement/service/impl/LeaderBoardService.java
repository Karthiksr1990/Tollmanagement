package com.tollmanagement.service.impl;

import com.tollmanagement.model.Metric;
import com.tollmanagement.model.Payment;
import com.tollmanagement.util.DateFormatter;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LeaderBoardService {

    private Map<String, List<Metric>> boothStats = new HashMap<>();

    public void collectStats(Payment payment) {
        String boothId = payment.getPaymentBoothId();
        List<Metric> list = boothStats.getOrDefault(boothId, new ArrayList<>());
        list.add(Metric.builder().amountCollected(payment.getAmount()).boothId(boothId).countOfPass(1).date(payment.getDate()).build());
        boothStats.put(boothId, list);
    }

    public Map<String, Double> getLeaderBoardByCost(int hrs) {
        Map<String, Double> result = new LinkedHashMap<>();
         boothStats.values().stream().flatMap(Collection::stream)
                   .filter(e -> e.getDate()
                   .compareTo(DateFormatter.getPreviousDate(hrs)) >= 0)
                   .collect(Collectors.groupingBy(e -> e.getBoothId(),
                           Collectors.summingDouble(e -> e.getAmountCollected())))
                   .entrySet().stream().sorted((a, b) -> b.getValue().compareTo(a.getValue()))
                   .forEach(e -> result.put(e.getKey(), e.getValue()));

        return result;
    }
}
