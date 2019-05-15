package com.cedacri.ppmrest.error;

import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


@ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
public class RuoloNonTrovatoException extends CedacriException {
    private static final String DESC = "Uno o più ruoli specificati nel payload della" +
            "richiesta non esistono sul DB applicativo";

    public RuoloNonTrovatoException() {
        super(DESC);
        code = 6;
        httpStatus = HttpStatus.UNPROCESSABLE_ENTITY;
    }
}



