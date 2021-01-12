package com.tollmanagement.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Collection;
import java.util.HashSet;

@Getter
@Setter
@ToString
public class Toll {

    private String tollId;
    private Collection<Booth> booths;

    public Toll(String tollId) {
        this.tollId = tollId;
        booths = new HashSet<>();
    }

    public void addBooth(Booth booth) {
        booths.add(booth);
    }

}
