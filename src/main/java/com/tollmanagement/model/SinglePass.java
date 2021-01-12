package com.tollmanagement.model;

import java.util.Date;

public class SinglePass extends Pass {
    public SinglePass(String passId, Date issuedDate, String vehicleId) {
        super(passId, issuedDate, vehicleId,PassType.SINGLE);
    }

    public SinglePass(){
        super(PassType.SINGLE);
    }
}
