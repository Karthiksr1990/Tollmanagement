package com.tollmanagement.service.impl;

import com.tollmanagement.dao.inmemory.PassDao;
import com.tollmanagement.dao.inmemory.PaymentDao;
import com.tollmanagement.factory.ApplicationFactory;
import com.tollmanagement.model.Booth;
import com.tollmanagement.model.BoothDTO;
import com.tollmanagement.model.BoothType;
import com.tollmanagement.model.Pass;
import com.tollmanagement.model.PassCatalog;
import com.tollmanagement.model.PassType;
import com.tollmanagement.model.Payment;
import com.tollmanagement.model.VehicleType;
import com.tollmanagement.service.PassService;
import com.tollmanagement.service.PaymentService;
import com.tollmanagement.strategy.impl.FourWheelerPricingStrategy;
import com.tollmanagement.strategy.impl.TwoWheelerPricingStrategy;
import com.tollmanagement.util.DateFormatter;
import com.tollmanagement.validator.Validator;
import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@AllArgsConstructor
public class PassServiceImpl implements PassService {

    private PassDao passDao;
    private PaymentService paymentService;


    @Override
    public Pass generatePass(Booth booth, String vehicleId, PassCatalog catalog) {
        List<BoothDTO> boothDTOS = new ArrayList<>();
        BoothDTO boothDTO = BoothDTO.builder().booth(booth).boothType(BoothType.ENTRY).build();
        boothDTOS.add(boothDTO);
        Pass pass = ApplicationFactory.getPass(catalog.getPassType(), catalog.getDaysValidity());
        pass.addBooth(boothDTO);
        pass.setVehicleId(vehicleId);
        pass.setPassId("Pass-" + UUID.randomUUID().toString());
        pass.setIssuedDate(DateFormatter.getPresentDate());
        passDao.storePass(pass);
        paymentService.payment(pass, catalog.getAmount());
        return pass;
    }

    @Override
    public void invalidate(Booth booth, Pass pass) {
        pass = passDao.getPass(pass.getPassId());
        pass.addBooth(BoothDTO.builder().booth(booth).boothType(BoothType.EXIT).build());
        passDao.invalidate(pass);
    }

    @Override
    public Pass getPass(String passId) {
        return passDao.getPass(passId);
    }

    @Override
    public List<PassCatalog> getPassCatalog() {
        return getCatalog();
    }

    @Override
    public boolean validatePass(Pass pass) {
        return ApplicationFactory.getValidator(pass.getPassType()).validate(pass);
    }

    private List<PassCatalog> getCatalog() {
        List<PassCatalog> passCatalogs = new ArrayList<>();
        int[] passTypesDays = {0, 1, 7};
        int i = 0;
        for (PassType passType : PassType.values()) {
            for (VehicleType vehicleType : VehicleType.values()) {
                PassCatalog passCatalog = PassCatalog.builder().
                        passType(passType).vehicleType(vehicleType).
                        daysValidity(passTypesDays[i]).
                        amount(vehicleType == VehicleType.TWO_WHEELER ? new TwoWheelerPricingStrategy().getPrice(passTypesDays[i])
                                : new FourWheelerPricingStrategy().getPrice(passTypesDays[i])).build();
                passCatalogs.add(passCatalog);
            }
            i++;
        }
        return passCatalogs;
    }
}
