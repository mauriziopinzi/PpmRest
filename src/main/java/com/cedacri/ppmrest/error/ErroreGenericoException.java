package com.cedacri.ppmrest.error;

import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;



public class ErroreGenericoException extends CedacriException {
    private static final String DESC = "Si è verificato sul server un errore generico";


    public ErroreGenericoException() {
        super(DESC);
        code = 999;
        httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
    }
}



