package com.tollmanagement.model;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class GeneralPass extends Pass {
    private int days;

    public GeneralPass(String passId, Date issuedDate, String vehicleId, int days) {
        super(passId, issuedDate, vehicleId, PassType.GENERAL);
        this.days = days;
    }

    public GeneralPass() {
        super(PassType.GENERAL);
    }
}
