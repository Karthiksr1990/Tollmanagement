package com.tollmanagement.strategy.impl;

import com.tollmanagement.strategy.PricingStrategy;

public class FourWheelerPricingStrategy implements PricingStrategy {
    @Override
    public double getPrice(int days) {
        if(days==0)return 400.00;
        return 400.00*0.8*days;
    }
}
