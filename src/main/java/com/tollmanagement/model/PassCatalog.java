package com.tollmanagement.model;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@ToString
@Builder
@Getter
public class PassCatalog {

    private PassType passType;
    private double amount;
    private VehicleType vehicleType;
    private int daysValidity;

}
