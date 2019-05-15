package com.cedacri.ppmrest.controller;

import com.cedacri.ppmrest.error.MatricolaNonTrovataException;
import com.cedacri.ppmrest.error.RuoloNonTrovatoException;
import com.cedacri.ppmrest.model.*;
import com.cedacri.ppmrest.repository.ProcedureRepositoryRuolo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api")
public class RuoloController {

    @Autowired
    private ProcedureRepositoryRuolo procedureRepositoryRuolo;


    @PostMapping(value = "/utenti/{matricola}/ruoli")
    public GenericResponse assignRoles(@PathVariable String matricola, @RequestBody Ruolo ruolo) {
        System.out.println(ruolo.toString());

        ruolo.mandatoryFieldCheck();

        if(matricola.equals("FAKEUSER")) {
            throw new MatricolaNonTrovataException();
        }
        if(ruolo.getIdRuoliApplicativi().contains("FAKEROLE")) {
            throw new RuoloNonTrovatoException();
        }



        GenericResponse r = new GenericResponse();
        r.getDatiAggiuntivi().setDatoAggiuntivo1("Test");
        if(ruolo.getIdRuoliApplicativi().contains("2")) {
            r.getDatiAggiuntivi().setAlreadyPresent(true);
        }
        return r;
    }

    @PostMapping(value = "/utenti/{matricola}/ruoli/elimina")
    public GenericResponse removesRoles(@PathVariable String matricola, @RequestBody Ruolo ruolo) {
        System.out.println(ruolo.toString());

        ruolo.mandatoryFieldCheck();

        if(matricola.equals("FAKEUSER")) {
            throw new MatricolaNonTrovataException();
        }
        if(ruolo.getIdRuoliApplicativi().contains("FAKEROLE")) {
            throw new RuoloNonTrovatoException();
        }

        GenericResponse r = new GenericResponse();
        r.getDatiAggiuntivi().setDatoAggiuntivo1("Test");
        if(ruolo.getIdRuoliApplicativi().contains("2")) {
            r.getDatiAggiuntivi().setNotExistent(true);
        }
        return r;
    }

    @PostMapping(value = "/utenti/{matricola}/ruoli/eliminatutti")
    public GenericResponse deleteRoles(@PathVariable String matricola, @RequestBody Ruolo ruolo) {
        System.out.println(matricola);
        System.out.println(ruolo.toString());

        if(matricola.equals("FAKEUSER")) {
            throw new MatricolaNonTrovataException();
        }
        GenericResponse r = new GenericResponse();
        r.getDatiAggiuntivi().setDatoAggiuntivo1("Test");
        return r;
    }








}
