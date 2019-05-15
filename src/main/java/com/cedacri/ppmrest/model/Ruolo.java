package com.cedacri.ppmrest.model;

import com.cedacri.ppmrest.error.RuoloNonValorizzatoException;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@ToString
public class Ruolo {

    @Getter @Setter List<String> idRuoliApplicativi = new ArrayList<>();
    @Getter @Setter String ndg;
    @Getter @Setter String codiceIstituto;
    @Getter @Setter String codiceFiliale;
    @Getter @Setter DatiAggiuntivi datiAggiuntivi;

    public void mandatoryFieldCheck() {
        if(idRuoliApplicativi.isEmpty()) {
            throw new RuoloNonValorizzatoException();
        }
    }


}
