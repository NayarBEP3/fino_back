package com.tiamat.fino.utils;

import com.tiamat.fino.enums.TransactionTypeEnum;
import com.tiamat.fino.exceptions.BadDataException;
import com.tiamat.fino.exceptions.NotFoundException;
import org.yaml.snakeyaml.util.EnumUtils;

import java.util.List;
import java.util.Optional;

public class ValidationUtils {

    public static void validateMandatory(String object, String message) {
        if(null == object || "".equals(object)) {
            throw new BadDataException(message);
        }
    }

    public static void validateMandatory(double object, String message) {
        if(object == 0) {
            throw new BadDataException(message);
        }
    }

    public static void validateMandatory(Optional<?> object, String message) {
        if(object.isEmpty()) {
            throw new NotFoundException(message);
        }
    }

    public static void isValid(Boolean value, String message) {
        if(!value) {
            throw new BadDataException(message);
        }
    }

}
