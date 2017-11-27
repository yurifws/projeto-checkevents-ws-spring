package br.com.checkEvents.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.checkEvents.model.Endereco;
import br.com.checkEvents.service.EnderecoService;

@Controller
@RequestMapping(value = "/endereco")
public class EnderecoController extends ControllerGeneric<Endereco, EnderecoService> {

}
