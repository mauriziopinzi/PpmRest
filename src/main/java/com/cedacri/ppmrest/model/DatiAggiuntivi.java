package com.cedacri.ppmrest.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class DatiAggiuntivi {

    @Getter @Setter String datoAggiuntivo1;
    @Getter @Setter String datoAggiuntivo2;
    @Getter @Setter String datoAggiuntivo3;
    @Getter @Setter Boolean alreadyPresent;
    @Getter @Setter Boolean notExistent;
}
