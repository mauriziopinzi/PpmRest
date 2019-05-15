package com.cedacri.ppmrest.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


@ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
public class RuoloNonValorizzatoException extends CedacriException {
    private static final String DESC = "Questo errore si presenta quando all’interno" +
            "di una richiesta il ruolo non viene" +
            "valorizzato anche se è richiesto come" +
            "campo obbligatorio";

    public RuoloNonValorizzatoException() {
        super(DESC);
        code = 6;
        httpStatus = HttpStatus.UNPROCESSABLE_ENTITY;
    }
}



