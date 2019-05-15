package com.cedacri.ppmrest.error;

import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


@ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
public class MatricolaNonValorizzataException extends CedacriException {
    private static final String DESC = "Questo errore si presenta quando all’interno" +
            "di una richiesta la matricola non viene" +
            "valorizzata anche se è indicata come campo" +
            "obbligatorio";


    public MatricolaNonValorizzataException() {
        super(DESC);
        code = 2;
        httpStatus = HttpStatus.UNPROCESSABLE_ENTITY;
    }
}



