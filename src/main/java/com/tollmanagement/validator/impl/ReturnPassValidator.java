package com.tollmanagement.validator.impl;

import com.tollmanagement.model.GeneralPass;
import com.tollmanagement.model.Pass;
import com.tollmanagement.model.ReturnPass;
import com.tollmanagement.util.DateFormatter;
import com.tollmanagement.validator.Validator;

import java.util.Date;

public class ReturnPassValidator implements Validator {
    @Override
    public boolean validate(Pass pass) {
        ReturnPass returnPass = (ReturnPass) pass;
        Date futureDate = DateFormatter.getFutureDate(returnPass.getIssuedDate(), 1);
        return !pass.isValid() || futureDate.compareTo(new Date()) < 0 ? false : true;
    }
}
