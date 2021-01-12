package com.tollmanagement.validator.impl;

import com.tollmanagement.model.GeneralPass;
import com.tollmanagement.model.Pass;
import com.tollmanagement.util.DateFormatter;
import com.tollmanagement.validator.Validator;

import java.util.Date;

public class GeneralPassValidator implements Validator {
    @Override
    public boolean validate(Pass pass) {
        GeneralPass generalPass = (GeneralPass) pass;
        Date futureDate = DateFormatter.getFutureDate(generalPass.getIssuedDate(), generalPass.getDays());
        return !pass.isValid() || futureDate.compareTo(new Date()) < 0 ? false : true;
    }
}
