package com.tollmanagement.test;

import com.tollmanagement.dao.inmemory.PassDao;
import com.tollmanagement.dao.inmemory.PaymentDao;
import com.tollmanagement.dao.inmemory.TollDao;
import com.tollmanagement.dao.inmemory.impl.PaymentDaoImpl;
import com.tollmanagement.dao.inmemory.impl.TollDaoImpl;
import com.tollmanagement.model.Booth;
import com.tollmanagement.model.Pass;
import com.tollmanagement.model.PassCatalog;
import com.tollmanagement.model.Toll;
import com.tollmanagement.service.BoothService;
import com.tollmanagement.service.PassService;
import com.tollmanagement.service.PaymentService;
import com.tollmanagement.service.impl.BoothServiceImpl;
import com.tollmanagement.service.impl.LeaderBoardService;
import com.tollmanagement.service.impl.PassServiceImpl;
import com.tollmanagement.service.impl.PaymentServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.UUID;

public class TollManagementIntegrationTest {

    static Booth booth1;
    static Booth booth2;
    static BoothService boothService;
    static LeaderBoardService leaderBoardService;

    @BeforeEach
    public void init() {
        PassDao passDao = TollDaoImpl.getInstance();
        TollDao tollDao = TollDaoImpl.getInstance();
        Toll toll = new Toll(UUID.randomUUID().toString());
        tollDao.createToll(toll);
        booth1 = new Booth(toll.getTollId(), UUID.randomUUID().toString());
        tollDao.addBooth(booth1);
        booth2 = new Booth(toll.getTollId(), UUID.randomUUID().toString());
        tollDao.addBooth(booth2);
        PaymentDao paymentDao = new PaymentDaoImpl();
        leaderBoardService = new LeaderBoardService();
        PaymentService paymentService = new PaymentServiceImpl(paymentDao, leaderBoardService);
        PassService passService = new PassServiceImpl(passDao, paymentService);
        boothService = new BoothServiceImpl(passService);

    }

    @Test
    public void test() {
        List<PassCatalog> list = boothService.getPassCatalog();
        System.out.println(list);
        int choose = 4;
        PassCatalog passCatalog = list.get(choose);
        String vehicleId = UUID.randomUUID().toString() + "vehicle";
        Pass pass = boothService.issuePass(booth1, vehicleId, passCatalog);
        System.out.println(boothService.validatePass(pass));
        System.out.println(pass);
        choose = 2;
        passCatalog = list.get(choose);
        pass = boothService.issuePass(booth1, vehicleId + "-1", passCatalog);
        System.out.println(boothService.validatePass(pass));
        System.out.println(pass);

        choose = 1;
        passCatalog = list.get(choose);
        pass = boothService.issuePass(booth2, vehicleId + "-2", passCatalog);
        System.out.println(boothService.validatePass(pass));
        System.out.println(pass);

        choose = 5;
        passCatalog = list.get(choose);
        pass = boothService.issuePass(booth2, vehicleId + "-3", passCatalog);
        System.out.println(boothService.validatePass(pass));
        System.out.println(pass);

        System.out.println(leaderBoardService.getLeaderBoardByCost(1));

    }
}
