package com.tollmanagement.factory;

import com.tollmanagement.model.GeneralPass;
import com.tollmanagement.model.Pass;
import com.tollmanagement.model.PassType;
import com.tollmanagement.model.ReturnPass;
import com.tollmanagement.model.SinglePass;
import com.tollmanagement.validator.Validator;
import com.tollmanagement.validator.impl.GeneralPassValidator;
import com.tollmanagement.validator.impl.ReturnPassValidator;
import com.tollmanagement.validator.impl.SinglePassValidator;

public class ApplicationFactory {

    public static Validator getValidator(PassType passType) {
        switch (passType.toString()) {
            case "SINGLE":
                return new SinglePassValidator();
            case "RETURN":
                return new ReturnPassValidator();
            case "GENERAL":
                return new GeneralPassValidator();
        }
        return null;
    }

    public static Pass getPass(PassType passType, int days) {

        switch (passType.toString()) {
            case "SINGLE":
                return new SinglePass();
            case "RETURN":
                return new ReturnPass();
            case "GENERAL":
                GeneralPass pass = new GeneralPass();
                pass.setDays(days);
                return pass;
        }
        return null;
    }
}
