package com.cedacri.ppmrest.model;

import com.cedacri.ppmrest.error.CognomeNonValorizzatoException;
import com.cedacri.ppmrest.error.IstitutoNonValorizzatoException;
import com.cedacri.ppmrest.error.MatricolaNonValorizzataException;
import com.cedacri.ppmrest.error.NomeNonValorizzatoException;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.apache.commons.lang3.StringUtils;

@ToString
public class Utente {

    @Getter @Setter String matricola;
    @Getter @Setter String nome;
    @Getter @Setter String cognome;
    @Getter @Setter String ndg;
    @Getter @Setter String lingua;
    @Getter @Setter String codiceIstituto;
    @Getter @Setter String codiceFiliale;
    @Getter @Setter DatiAggiuntivi datiAggiuntivi;

    public void mandatoryFieldCheckCreate() {
        if(StringUtils.isEmpty(matricola)) {
            throw new MatricolaNonValorizzataException();
        }
        if(StringUtils.isEmpty(nome)) {
            throw new NomeNonValorizzatoException();
        }
        if(StringUtils.isEmpty(cognome)) {
            throw new CognomeNonValorizzatoException();
        }
        if(StringUtils.isEmpty(codiceIstituto)) {
            throw new IstitutoNonValorizzatoException();
        }
    }
    public void mandatoryFieldCheckUpdate() {
        if(StringUtils.isEmpty(nome)) {
            throw new NomeNonValorizzatoException();
        }
        if(StringUtils.isEmpty(cognome)) {
            throw new CognomeNonValorizzatoException();
        }
        if(StringUtils.isEmpty(codiceIstituto)) {
            throw new IstitutoNonValorizzatoException();
        }
    }
}
