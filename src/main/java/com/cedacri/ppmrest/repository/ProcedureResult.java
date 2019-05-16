package com.cedacri.ppmrest.repository;

import com.cedacri.ppmrest.error.ErroreGenericoException;
import com.cedacri.ppmrest.error.MatricolaNonTrovataException;
import com.cedacri.ppmrest.error.RuoloNonTrovatoException;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.StringUtils;

import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProcedureResult implements Serializable {


    private static final String KO = "KO";
    private static final String MATRICOLA_NOT_FOUND = "matricolanotfound";
    private static final String GENERIC = "generic";
    private static final String ROLE_NOT_FOUND = "rolenotfound";

    private static final String OK = "OK";
    private static final String ALREADY_PRESENT = "alreadypresent";
    private static final String NOT_EXISTENT = "notexistent";

    private String result;
    private String resultDetails;

    public void checkKo() {
        if(result.equals(KO)) {
            if(resultDetails.equals(MATRICOLA_NOT_FOUND)) {
                throw new MatricolaNonTrovataException();
            } else if(resultDetails.equals(ROLE_NOT_FOUND)) {
                throw new RuoloNonTrovatoException();
            } else if(resultDetails.equals(GENERIC)) {
                throw new ErroreGenericoException();
            } else {
                throw new ErroreGenericoException();
            }
        }
    }
    private Boolean checkOkNotExistent() {
        if(result.equals(OK)) {
            if (resultDetails.equals(NOT_EXISTENT)) {
                return true;
            } else {
                return false;
            }
        }
        throw new ErroreGenericoException();
    }
    private Boolean checkOkAlreadyPresent() {
        if(result.equals(OK)) {
            if (resultDetails.equals(ALREADY_PRESENT)) {
                return true;
            } else {
                return false;
            }
        }
        throw new ErroreGenericoException();
    }


    public Boolean checkKoOrAlreadyPresent() {
        checkKo();
        return checkOkAlreadyPresent();
    }
    public Boolean checkKoOrNotExistent() {
        checkKo();
        return checkOkNotExistent();
    }
    public String getIdApplicativo() {
        if(result.equals(OK)) {
            if (StringUtils.isNoneEmpty(resultDetails)) {
                return resultDetails;
            } else {
                return "";
            }
        }
        return "";
    }


}