package com.cedacri.ppmrest.error;

import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


@ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
public class NomeNonValorizzatoException extends CedacriException {
    private static final String DESC = "Questo errore si presenta quando all’interno" +
            "di una richiesta il nome non viene" +
            "valorizzato anche se è richiesto come" +
            "campo obbligatorio";

    public NomeNonValorizzatoException() {
        super(DESC);
        code = 3;
        httpStatus = HttpStatus.UNPROCESSABLE_ENTITY;
    }
}



