package com.cedacri.ppmrest.error;


import com.cedacri.ppmrest.error.AutenticazioneFallitaException;
import com.cedacri.ppmrest.error.CedacriException;
import com.cedacri.ppmrest.error.ErrorDetail;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;

@Component
public class RestAuthenticationEntryPoint implements AuthenticationEntryPoint {

    @Override
    public void commence(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException, ServletException {

        CedacriException ex = new AutenticazioneFallitaException();
        httpServletResponse.setStatus(Integer.valueOf(ex.getHttpStatus().value()));
        ErrorDetail error = new ErrorDetail(ex);
        OutputStream out = httpServletResponse.getOutputStream();
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(out, error);
        out.flush();



    }
}
