package com.cedacri.ppmrest.error;

import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

public class AutenticazioneFallitaException extends CedacriException {
    private static final String DESC = "L’autenticazione al servizio è fallita";

    public AutenticazioneFallitaException() {
        super(DESC);
        code = 100;
        httpStatus = HttpStatus.UNPROCESSABLE_ENTITY;
    }
}



