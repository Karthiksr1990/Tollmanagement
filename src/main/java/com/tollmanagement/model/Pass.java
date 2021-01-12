package com.tollmanagement.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Collection;
import java.util.Date;
import java.util.LinkedHashSet;

@ToString
@Getter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Builder
@AllArgsConstructor
@Setter
public class Pass {

    @EqualsAndHashCode.Include
    private String passId;
    private Collection<BoothDTO> booths;
    private Date issuedDate;
    private String vehicleId;
    private boolean isValid;
    private PassType passType;

    public Pass(String passId, Date issuedDate, String vehicleId, PassType passType) {
        this.passId = passId;
        this.issuedDate = issuedDate;
        this.vehicleId = vehicleId;
        isValid = true;
        booths = new LinkedHashSet<>();
        this.passType = passType;
    }

    public Pass(PassType passType) {
        isValid = true;
        booths = new LinkedHashSet<>();
        this.passType = passType;
    }

    public void addBooth(BoothDTO boothDTO) {
        booths.add(boothDTO);
    }
}
