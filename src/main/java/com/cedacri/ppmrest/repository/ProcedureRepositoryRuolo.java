package com.cedacri.ppmrest.repository;


import com.cedacri.ppmrest.model.Ruolo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureQuery;

@Repository
public class ProcedureRepositoryRuolo {

    @Autowired
    EntityManager entityManager;

    private static final String RESULT = "p_result";
    private static final String RESULT_DETAILS = "p_result_details";

    private static final String MATRICOLA = "p_matricola";
    private static final String ID_RUOLI_APPLICATIVI = "p_ruoli_applicativi";
    private static final String NDG = "p_ndg";
    private static final String CODICE_ISTITUTO = "p_codice_istituto";
    private static final String CODICE_FILIALE = "p_codice_filiale";
    private static final String DATO_AGGIUNTIVO1 = "p_dato_aggiuntivo1";
    private static final String DATO_AGGIUNTIVO2 = "p_dato_aggiuntivo2";
    private static final String DATO_AGGIUNTIVO3 = "p_dato_aggiuntivo3";


    private static final String ADD_ROLE_PROCEDURE = "add_role";
    private static final String DELETE_ROLE_PROCEDURE = "delete_role";
    private static final String DELETE_ALL_ROLES_PROCEDURE = "delete_all_roles ";


    public ProcedureResult addRoleProcedure(String matricola, Ruolo ruolo) {
        StoredProcedureQuery proc = getStoredProcedureQuery(matricola,ruolo,ADD_ROLE_PROCEDURE);
        proc.execute();
        return ProcedureResult.builder()
                .result((String) proc.getOutputParameterValue(RESULT))
                .resultDetails((String) proc.getOutputParameterValue(RESULT_DETAILS))
                .build();
    }
    public ProcedureResult deleteRoleProcedure(String matricola, Ruolo ruolo) {
        StoredProcedureQuery proc = getStoredProcedureQuery(matricola,ruolo,DELETE_ROLE_PROCEDURE);
        proc.execute();
        return ProcedureResult.builder()
                .result((String) proc.getOutputParameterValue(RESULT))
                .resultDetails((String) proc.getOutputParameterValue(RESULT_DETAILS))
                .build();
    }

    public ProcedureResult deleteAllRolesProcedure(String matricola, Ruolo ruolo) {
        StoredProcedureQuery proc = getStoredProcedureQueryDeleteAll(matricola,ruolo,DELETE_ALL_ROLES_PROCEDURE);
        proc.execute();
        return ProcedureResult.builder()
                .result((String) proc.getOutputParameterValue(RESULT))
                .resultDetails((String) proc.getOutputParameterValue(RESULT_DETAILS))
                .build();
    }

    private StoredProcedureQuery getStoredProcedureQueryDeleteAll(String matricola, Ruolo ruolo, String spName) {
        StoredProcedureQuery proc = entityManager.createStoredProcedureQuery(spName);
        proc.registerStoredProcedureParameter(MATRICOLA, String.class, ParameterMode.IN);
        proc.registerStoredProcedureParameter(DATO_AGGIUNTIVO1, String.class, ParameterMode.IN);
        proc.registerStoredProcedureParameter(DATO_AGGIUNTIVO2, String.class, ParameterMode.IN);
        proc.registerStoredProcedureParameter(DATO_AGGIUNTIVO3, String.class, ParameterMode.IN);

        proc.registerStoredProcedureParameter(RESULT, String.class, ParameterMode.OUT);
        proc.registerStoredProcedureParameter(RESULT_DETAILS, String.class, ParameterMode.OUT);

        proc.setParameter(MATRICOLA, matricola);
        proc.setParameter(DATO_AGGIUNTIVO1, ruolo.getDatiAggiuntivi().getDatoAggiuntivo1());
        proc.setParameter(DATO_AGGIUNTIVO2, ruolo.getDatiAggiuntivi().getDatoAggiuntivo2());
        proc.setParameter(DATO_AGGIUNTIVO3, ruolo.getDatiAggiuntivi().getDatoAggiuntivo3());
        return proc;
    }


    private StoredProcedureQuery getStoredProcedureQuery(String matricola, Ruolo ruolo, String spName) {
        StoredProcedureQuery proc = entityManager.createStoredProcedureQuery(spName);
        proc.registerStoredProcedureParameter(MATRICOLA, String.class, ParameterMode.IN);
        proc.registerStoredProcedureParameter(ID_RUOLI_APPLICATIVI, String.class, ParameterMode.IN);
        proc.registerStoredProcedureParameter(NDG, String.class, ParameterMode.IN);
        proc.registerStoredProcedureParameter(CODICE_ISTITUTO, String.class, ParameterMode.IN);
        proc.registerStoredProcedureParameter(CODICE_FILIALE, String.class, ParameterMode.IN);
        proc.registerStoredProcedureParameter(DATO_AGGIUNTIVO1, String.class, ParameterMode.IN);
        proc.registerStoredProcedureParameter(DATO_AGGIUNTIVO2, String.class, ParameterMode.IN);
        proc.registerStoredProcedureParameter(DATO_AGGIUNTIVO3, String.class, ParameterMode.IN);

        proc.registerStoredProcedureParameter(RESULT, String.class, ParameterMode.OUT);
        proc.registerStoredProcedureParameter(RESULT_DETAILS, String.class, ParameterMode.OUT);

        proc.setParameter(MATRICOLA, matricola);
        proc.setParameter(ID_RUOLI_APPLICATIVI, StringUtils.join(ruolo.getIdRuoliApplicativi(), ','));
        proc.setParameter(NDG, ruolo.getNdg());
        proc.setParameter(CODICE_ISTITUTO, ruolo.getCodiceIstituto());
        proc.setParameter(CODICE_FILIALE, ruolo.getCodiceFiliale());
        proc.setParameter(DATO_AGGIUNTIVO1, ruolo.getDatiAggiuntivi().getDatoAggiuntivo1());
        proc.setParameter(DATO_AGGIUNTIVO2, ruolo.getDatiAggiuntivi().getDatoAggiuntivo2());
        proc.setParameter(DATO_AGGIUNTIVO3, ruolo.getDatiAggiuntivi().getDatoAggiuntivo3());
        return proc;
    }


}
