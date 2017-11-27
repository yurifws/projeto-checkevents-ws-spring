package br.com.checkEvents.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.checkEvents.dao.ContatoRepository;
import br.com.checkEvents.model.Contato;

@Service
@Transactional
public class ContatoService extends ServiceGeneric<Contato, ContatoRepository> {

}
