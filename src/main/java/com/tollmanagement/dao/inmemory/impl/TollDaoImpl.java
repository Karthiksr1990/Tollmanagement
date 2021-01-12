package com.tollmanagement.dao.inmemory.impl;

import com.tollmanagement.dao.inmemory.TollDao;
import com.tollmanagement.model.Booth;
import com.tollmanagement.model.Pass;
import com.tollmanagement.model.Toll;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

public class TollDaoImpl implements TollDao {

    private Map<String, Pass> vehicleListMap;
    private Map<Toll, Set<Booth>> tollBoothMap;

    private static TollDaoImpl instance = new TollDaoImpl();

    private TollDaoImpl() {
        vehicleListMap = new HashMap<>();
        tollBoothMap = new HashMap<>();
    }

    public static TollDaoImpl getInstance() {
        return instance;
    }

    @Override
    public void addBooth(Booth booth) {
        String tollId = booth.getTollId();
        Toll toll = new Toll(tollId);
        Set<Booth> booths = tollBoothMap.getOrDefault(toll, new HashSet<>());
        booths.add(booth);
    }

    @Override
    public void createToll(Toll toll) {
        tollBoothMap.put(toll,new HashSet<>());
    }

    @Override
    public void storePass(Pass pass) {
        vehicleListMap.put(pass.getPassId(), pass);
    }

    @Override
    public void invalidate(Pass pass) {
        Pass pass1 = vehicleListMap.get(pass.getPassId());
        if (null != pass1) {
            pass1.setValid(false);
            vehicleListMap.put(pass1.getPassId(), pass1);
        }
    }

    @Override
    public Pass getPass(String passId) {
        return vehicleListMap.get(passId);
    }

}
