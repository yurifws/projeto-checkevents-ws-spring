package br.com.checkEvents.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.checkEvents.model.TipoEvento;
import br.com.checkEvents.service.TipoEventoService;

@Controller
@RequestMapping(value = "/tipoEvento")
public class TipoEventoController extends ControllerGeneric<TipoEvento, TipoEventoService> {

}
