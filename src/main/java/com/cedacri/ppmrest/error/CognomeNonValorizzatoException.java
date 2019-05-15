package com.cedacri.ppmrest.error;

import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;



public class CognomeNonValorizzatoException extends CedacriException {
    private static final String DESC = "Questo errore si presenta quando all’interno" +
            "di una richiesta il cognome non viene" +
            "valorizzato anche se è richiesto come" +
            "campo obbligatorio";

    public CognomeNonValorizzatoException() {
        super(DESC);
        code = 4;
        httpStatus = HttpStatus.UNPROCESSABLE_ENTITY;
    }
}



