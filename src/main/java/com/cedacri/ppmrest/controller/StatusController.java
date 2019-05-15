package com.cedacri.ppmrest.controller;

import com.cedacri.ppmrest.error.MatricolaNonTrovataException;
import com.cedacri.ppmrest.error.RuoloNonTrovatoException;
import com.cedacri.ppmrest.model.*;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api")
public class StatusController {

    @GetMapping(value = "/status")
    public DatiAggiuntivi status() {
        return new DatiAggiuntivi();
    }

}
