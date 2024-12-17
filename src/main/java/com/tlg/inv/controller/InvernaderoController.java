// InvernaderoController.java
package com.tlg.inv.controller;

import com.tlg.inv.service.InvernaderoService;
import com.tlg.inv.model.Invernadero;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.ui.Model;
import java.util.List;


@Controller
public class InvernaderoController {
    private static final Logger logger = LoggerFactory.getLogger(InvernaderoController.class);

    @Autowired
    private InvernaderoService invernaderoService;

    @GetMapping("/listaInvernaderos")
    public String listaInvernaderos(Model model) { 
        model.addAttribute("invernaderos", invernaderoService.obtenerTodosLosInvernaderos()); 
        return "listaInvernaderos";
    }

    @PostMapping("/detalleInvernadero")
    public String detalleInvernadero(@RequestParam("id") String id, Model model) {
        Invernadero invernadero = invernaderoService.obtenerInvernaderoPorId(id);
        model.addAttribute("invernadero", invernadero);
        return "detalleInvernadero";
    }

}
