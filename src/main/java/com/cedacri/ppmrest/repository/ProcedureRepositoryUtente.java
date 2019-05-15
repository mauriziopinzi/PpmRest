package com.cedacri.ppmrest.repository;


import com.cedacri.ppmrest.model.Utente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureQuery;

@Repository
public class ProcedureRepositoryUtente {

    @Autowired
    EntityManager entityManager;

    private static final String RESULT = "p_result";
    private static final String RESULT_DETAILS = "p_result_details";

    private static final String MATRICOLA = "p_matricola";
    private static final String NOME = "p_nome";
    private static final String COGNOME = "p_cognome";
    private static final String NDG = "p_ndg";
    private static final String LINGUA = "p_lingua";
    private static final String CODICE_ISTITUTO = "p_codice_istituto";
    private static final String CODICE_FILIALE = "p_codice_filiale";
    private static final String DATO_AGGIUNTIVO1 = "p_dato_aggiuntivo1";
    private static final String DATO_AGGIUNTIVO2 = "p_dato_aggiuntivo2";
    private static final String DATO_AGGIUNTIVO3 = "p_dato_aggiuntivo3";

    private static final String ADD_USER_PROCEDURE = "add_user";
    private static final String UPDATE_USER_PROCEDURE = "update_user";
    private static final String DELETE_USER_PROCEDURE = "delete_user";


    public ProcedureResult addUserProcedure(Utente utente) {
        StoredProcedureQuery proc = getStoredProcedureQuery(utente,ADD_USER_PROCEDURE);
        proc.execute();
        return ProcedureResult.builder()
                .result((String) proc.getOutputParameterValue(RESULT))
                .resultDetails((String) proc.getOutputParameterValue(RESULT_DETAILS))
                .build();
    }
    public ProcedureResult updateUserProcedure(Utente utente) {
        StoredProcedureQuery proc = getStoredProcedureQuery(utente,UPDATE_USER_PROCEDURE);
        proc.execute();
        return ProcedureResult.builder()
                .result((String) proc.getOutputParameterValue(RESULT))
                .resultDetails((String) proc.getOutputParameterValue(RESULT_DETAILS))
                .build();
    }

    public ProcedureResult deleteUserProcedure(Utente utente) {
        StoredProcedureQuery proc = getStoredProcedureQuery(utente,DELETE_USER_PROCEDURE);
        proc.execute();
        return ProcedureResult.builder()
                .result((String) proc.getOutputParameterValue(RESULT))
                .resultDetails((String) proc.getOutputParameterValue(RESULT_DETAILS))
                .build();
    }

    private StoredProcedureQuery getStoredProcedureQueryDelete(Utente utente, String spName) {
        StoredProcedureQuery proc = entityManager.createStoredProcedureQuery(spName);
        proc.registerStoredProcedureParameter(MATRICOLA, String.class, ParameterMode.IN);
        proc.registerStoredProcedureParameter(DATO_AGGIUNTIVO1, String.class, ParameterMode.IN);
        proc.registerStoredProcedureParameter(DATO_AGGIUNTIVO2, String.class, ParameterMode.IN);
        proc.registerStoredProcedureParameter(DATO_AGGIUNTIVO3, String.class, ParameterMode.IN);

        proc.registerStoredProcedureParameter(RESULT, String.class, ParameterMode.OUT);
        proc.registerStoredProcedureParameter(RESULT_DETAILS, String.class, ParameterMode.OUT);

        proc.setParameter(MATRICOLA, utente.getMatricola());
        proc.setParameter(DATO_AGGIUNTIVO1, utente.getDatiAggiuntivi().getDatoAggiuntivo1());
        proc.setParameter(DATO_AGGIUNTIVO2, utente.getDatiAggiuntivi().getDatoAggiuntivo2());
        proc.setParameter(DATO_AGGIUNTIVO3, utente.getDatiAggiuntivi().getDatoAggiuntivo3());
        return proc;
    }


    private StoredProcedureQuery getStoredProcedureQuery(Utente utente, String spName) {
        StoredProcedureQuery proc = entityManager.createStoredProcedureQuery(spName);
        proc.registerStoredProcedureParameter(MATRICOLA, String.class, ParameterMode.IN);
        proc.registerStoredProcedureParameter(NOME, String.class, ParameterMode.IN);
        proc.registerStoredProcedureParameter(COGNOME, String.class, ParameterMode.IN);
        proc.registerStoredProcedureParameter(NDG, String.class, ParameterMode.IN);
        proc.registerStoredProcedureParameter(LINGUA, String.class, ParameterMode.IN);
        proc.registerStoredProcedureParameter(CODICE_ISTITUTO, String.class, ParameterMode.IN);
        proc.registerStoredProcedureParameter(CODICE_FILIALE, String.class, ParameterMode.IN);
        proc.registerStoredProcedureParameter(DATO_AGGIUNTIVO1, String.class, ParameterMode.IN);
        proc.registerStoredProcedureParameter(DATO_AGGIUNTIVO2, String.class, ParameterMode.IN);
        proc.registerStoredProcedureParameter(DATO_AGGIUNTIVO3, String.class, ParameterMode.IN);

        proc.registerStoredProcedureParameter(RESULT, String.class, ParameterMode.OUT);
        proc.registerStoredProcedureParameter(RESULT_DETAILS, String.class, ParameterMode.OUT);


        proc.setParameter(MATRICOLA, utente.getMatricola());
        proc.setParameter(NOME, utente.getNome());
        proc.setParameter(COGNOME, utente.getCognome());
        proc.setParameter(NDG, utente.getNdg());
        proc.setParameter(LINGUA, utente.getLingua());
        proc.setParameter(CODICE_ISTITUTO, utente.getCodiceIstituto());
        proc.setParameter(CODICE_FILIALE, utente.getCodiceFiliale());
        proc.setParameter(DATO_AGGIUNTIVO1, utente.getDatiAggiuntivi().getDatoAggiuntivo1());
        proc.setParameter(DATO_AGGIUNTIVO2, utente.getDatiAggiuntivi().getDatoAggiuntivo2());
        proc.setParameter(DATO_AGGIUNTIVO3, utente.getDatiAggiuntivi().getDatoAggiuntivo3());
        return proc;
    }


}
