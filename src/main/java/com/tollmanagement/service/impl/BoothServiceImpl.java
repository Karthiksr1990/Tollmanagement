package com.tollmanagement.service.impl;

import com.tollmanagement.model.Booth;
import com.tollmanagement.model.Pass;
import com.tollmanagement.model.PassCatalog;
import com.tollmanagement.service.BoothService;
import com.tollmanagement.service.PassService;
import lombok.AllArgsConstructor;

import java.util.List;
@AllArgsConstructor
public class BoothServiceImpl implements BoothService {

    private PassService passService;

    @Override
    public Pass issuePass(Booth booth, String vehicleId, PassCatalog catalog) {
        return passService.generatePass(booth, vehicleId, catalog);

    }

    @Override
    public List<PassCatalog> getPassCatalog() {
        return passService.getPassCatalog();
    }

    @Override
    public boolean validatePass(Pass pass) {
        return passService.validatePass(pass);
    }
}
