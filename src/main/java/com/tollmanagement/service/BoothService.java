package com.tollmanagement.service;

import com.tollmanagement.model.Booth;
import com.tollmanagement.model.Pass;
import com.tollmanagement.model.PassCatalog;

import java.util.List;

public interface BoothService {
    Pass issuePass(Booth booth, String vehicleId, PassCatalog catalog);

    List<PassCatalog> getPassCatalog();

    boolean validatePass(Pass pass);
}
