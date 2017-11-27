package br.com.checkEvents.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.checkEvents.model.Localizacao;
import br.com.checkEvents.service.LocalizacaoService;

@Controller
@RequestMapping(value = "/localizacao")
public class LocalizacaoController extends ControllerGeneric<Localizacao, LocalizacaoService> {

}
