package com.cedacri.ppmrest.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class CreaUtenteResponse {

    @Getter @Setter String utenzaApplicativaInterna;
    @Getter @Setter DatiAggiuntivi datiAggiuntivi = new DatiAggiuntivi();
}
