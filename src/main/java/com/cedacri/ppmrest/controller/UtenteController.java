package com.cedacri.ppmrest.controller;

import com.cedacri.ppmrest.error.MatricolaNonTrovataException;
import com.cedacri.ppmrest.error.RuoloNonTrovatoException;
import com.cedacri.ppmrest.model.*;
import com.cedacri.ppmrest.repository.ProcedureRepositoryRuolo;
import com.cedacri.ppmrest.repository.ProcedureRepositoryUtente;
import com.cedacri.ppmrest.repository.ProcedureResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api")
public class UtenteController {

    @Autowired
    private ProcedureRepositoryUtente procedureRepositoryUtente;

    @PostMapping(value = "/utenti")
    public CreaUtenteResponse createUser(@RequestBody Utente utente) {
        System.out.println(utente.toString());
        utente.mandatoryFieldCheckCreate();

        ProcedureResult result = procedureRepositoryUtente.addUserProcedure(utente);

        CreaUtenteResponse response = new CreaUtenteResponse();
        if(result.checkKoOrAlreadyPresent()) {
            response.getDatiAggiuntivi().setAlreadyPresent(true);
        } else {
            response.setUtenzaApplicativaInterna(result.getIdApplicativo());
        }
        return response;
    }

    @PostMapping(value = "/utenti/{matricola}/aggiorna")
    public CreaUtenteResponse updateUser(@PathVariable String matricola, @RequestBody Utente utente) {
        System.out.println(utente.toString());
        utente.setMatricola(matricola);
        utente.mandatoryFieldCheckUpdate();

        ProcedureResult result = procedureRepositoryUtente.updateUserProcedure(utente);
        result.checkKo();

        CreaUtenteResponse response = new CreaUtenteResponse();
        return response;
    }

    @PostMapping(value = "/utenti/{matricola}/elimina")
    public GenericResponse deleteUser(@PathVariable String matricola, @RequestBody DatiAggiuntivi datiAggiuntivi) {

        Utente utente = new Utente();
        utente.setMatricola(matricola);
        utente.setDatiAggiuntivi(datiAggiuntivi);

        ProcedureResult result = procedureRepositoryUtente.deleteUserProcedure(utente);
        result.checkKo();

        GenericResponse response = new GenericResponse();
        return response;
    }

}
