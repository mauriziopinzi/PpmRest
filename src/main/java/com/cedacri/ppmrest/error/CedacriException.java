package com.cedacri.ppmrest.error;

import lombok.Getter;
import org.springframework.http.HttpStatus;

public class CedacriException extends RuntimeException {

    @Getter  protected Integer code;
    @Getter protected HttpStatus httpStatus;

    CedacriException(String desc) {
        super(desc);
    }
}
