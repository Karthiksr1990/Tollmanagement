package com.tollmanagement.service;

import com.tollmanagement.model.Booth;
import com.tollmanagement.model.Pass;
import com.tollmanagement.model.PassCatalog;

import java.util.List;

public interface PassService {

    Pass generatePass(Booth booth, String vehicleId, PassCatalog catalog);

    void invalidate(Booth booth,Pass pass);

    Pass getPass(String passId);

    List<PassCatalog> getPassCatalog();

    boolean validatePass(Pass pass);
}
