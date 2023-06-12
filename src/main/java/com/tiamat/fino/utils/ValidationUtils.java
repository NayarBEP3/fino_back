package com.tiamat.fino.utils;

import com.tiamat.fino.exceptions.BadDataException;
import com.tiamat.fino.exceptions.NotFoundException;

import java.util.Optional;

public class ValidationUtils {

    public static void validateMandatory(String object, String message) {
        if(null == object || "".equals(object)) {
            throw new BadDataException(message);
        }
    }

}
