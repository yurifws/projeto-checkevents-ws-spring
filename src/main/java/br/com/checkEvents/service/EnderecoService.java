package br.com.checkEvents.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.checkEvents.dao.EnderecoRepository;
import br.com.checkEvents.model.Endereco;

@Service
@Transactional
public class EnderecoService extends ServiceGeneric<Endereco, EnderecoRepository> {

}
