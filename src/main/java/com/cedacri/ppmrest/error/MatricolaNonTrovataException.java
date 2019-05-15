package com.cedacri.ppmrest.error;

import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;



public class MatricolaNonTrovataException extends CedacriException {
    private static final String DESC = "Questo errore si presenta quando viene " +
            "effettuata una richiesta di update " +
            "aggiornamento anagrafica associazione o " +
            "disassociazione ruoli cessazione " +
            "anagrafica su di una matricola non " +
            "esistente sul DB applicativo";

    private static final String DESC1 = "A";

    public MatricolaNonTrovataException() {
        super(DESC);
        code = 5;
        httpStatus = HttpStatus.UNPROCESSABLE_ENTITY;
    }
}



