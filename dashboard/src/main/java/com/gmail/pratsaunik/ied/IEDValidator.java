package com.gmail.pratsaunik.ied;

import com.gmail.pratsaunik.pojo.IED;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class IEDValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return IED.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        if (target == null) {
            errors.reject("object.null", "Product item is null");
            return;
        }
        IED item = (IED) target;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "feederName", "name.empty", "The item name is empty");
        if (item.getDeviceId() == null || item.getDeviceId() <= 0) {
            errors.rejectValue("deviceid", "deviceid.null", "The deviceid is 0 or negative");
        }
    }
}