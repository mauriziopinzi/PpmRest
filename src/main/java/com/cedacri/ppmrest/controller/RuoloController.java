package com.cedacri.ppmrest.controller;

import com.cedacri.ppmrest.error.MatricolaNonTrovataException;
import com.cedacri.ppmrest.error.RuoloNonTrovatoException;
import com.cedacri.ppmrest.model.*;
import com.cedacri.ppmrest.repository.ProcedureRepositoryRuolo;
import com.cedacri.ppmrest.repository.ProcedureResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api")
public class RuoloController {

    @Autowired
    private ProcedureRepositoryRuolo procedureRepositoryRuolo;


    @PostMapping(value = "/utenti/{matricola}/ruoli")
    public GenericResponse assignRoles(@PathVariable String matricola, @RequestBody Ruolo ruolo) {

        ruolo.mandatoryFieldCheck();

        ProcedureResult result = procedureRepositoryRuolo.addRoleProcedure(matricola,ruolo);

        GenericResponse response = new GenericResponse();
        if(result.checkKoOrAlreadyPresent()) {
            response.getDatiAggiuntivi().setAlreadyPresent(true);
        }
        return response;
    }

    @PostMapping(value = "/utenti/{matricola}/ruoli/elimina")
    public GenericResponse removesRoles(@PathVariable String matricola, @RequestBody Ruolo ruolo) {

        ruolo.mandatoryFieldCheck();
        ProcedureResult result = procedureRepositoryRuolo.deleteRoleProcedure(matricola,ruolo);

        GenericResponse response = new GenericResponse();
        if(result.checkKoOrNotExistent()) {
            response.getDatiAggiuntivi().setNotExistent(true);
        }
        return response;
    }

    @PostMapping(value = "/utenti/{matricola}/ruoli/eliminatutti")
    public GenericResponse deleteRoles(@PathVariable String matricola, @RequestBody Ruolo ruolo) {

        ProcedureResult result = procedureRepositoryRuolo.deleteAllRolesProcedure(matricola,ruolo);
        result.checkKo();

        GenericResponse response = new GenericResponse();
        return response;
    }








}
