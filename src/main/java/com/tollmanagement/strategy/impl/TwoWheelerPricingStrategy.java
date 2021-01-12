package com.tollmanagement.strategy.impl;

import com.tollmanagement.strategy.PricingStrategy;

public class TwoWheelerPricingStrategy implements PricingStrategy {
    @Override
    public double getPrice(int days) {
        if (days == 0) return 100.00;
        return 100.00 * 0.8 * days;
    }
}
