package br.com.checkEvents.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.checkEvents.model.Contato;
import br.com.checkEvents.service.ContatoService;

@Controller
@RequestMapping(value = "/contato")
public class ContatoController extends ControllerGeneric<Contato, ContatoService> {

}
