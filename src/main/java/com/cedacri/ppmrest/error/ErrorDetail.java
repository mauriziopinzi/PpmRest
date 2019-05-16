package com.cedacri.ppmrest.error;

import lombok.Getter;
import lombok.Setter;

public class ErrorDetail {

    @Getter private Integer codice;
    @Getter private String descrizione;

    public ErrorDetail(CedacriException ex) {
        codice = ex.getCode();
        descrizione = ex.getMessage();
    }

}
