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


        boolean alreadyPresent = true;
        CreaUtenteResponse r = new CreaUtenteResponse();
        if(alreadyPresent) {
            r.getDatiAggiuntivi().setAlreadyPresent(true);
        }
        return r;
    }

    @PostMapping(value = "/utenti/{matricola}/aggiorna")
    public CreaUtenteResponse updateUser(@PathVariable String matricola, @RequestBody Utente utente) {
        System.out.println(utente.toString());

        utente.setMatricola(matricola);
        utente.mandatoryFieldCheckUpdate();

        if(matricola.equals("FAKEUSER")) {
            throw new MatricolaNonTrovataException();
        }

        CreaUtenteResponse r = new CreaUtenteResponse();
        return r;
    }

    @PostMapping(value = "/utenti/{matricola}/elimina")
    public GenericResponse deleteUser(@PathVariable String matricola, @RequestBody DatiAggiuntivi datiAggiuntivi) {

        Utente utente = new Utente();
        utente.setMatricola(matricola);
        utente.setDatiAggiuntivi(datiAggiuntivi);

        if(utente.getMatricola().equals("FAKEUSER")) {
            throw new MatricolaNonTrovataException();
        }
        GenericResponse r = new GenericResponse();
        r.getDatiAggiuntivi().setDatoAggiuntivo1("Test");
        return r;
    }

}
