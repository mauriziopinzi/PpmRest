package com.cedacri.ppmrest.error;

import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


public class IstitutoNonValorizzatoException extends CedacriException {
    private static final String DESC = "Questo errore si presenta quando all’interno" +
            "di una richiesta l’istituto non viene" +
            "valorizzato anche se è richiesto come" +
            "campo obbligatorio";


    public IstitutoNonValorizzatoException() {
        super(DESC);
        code = 1;
        httpStatus = HttpStatus.UNPROCESSABLE_ENTITY;
    }
}



