package com.tollmanagement.model;

import java.util.Date;

public class ReturnPass extends Pass {
    public ReturnPass(String passId, Date issuedDate, String vehicleId) {
        super(passId, issuedDate, vehicleId, PassType.RETURN);
    }

    public ReturnPass() {
        super(PassType.RETURN);
    }
}
