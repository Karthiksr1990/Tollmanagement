package com.tollmanagement.validator.impl;

import com.tollmanagement.model.Pass;
import com.tollmanagement.validator.Validator;

public class SinglePassValidator implements Validator {
    @Override
    public boolean validate(Pass pass) {
        return !pass.isValid() || pass.getBooths().size() > 0 ? false : true;
    }
}
