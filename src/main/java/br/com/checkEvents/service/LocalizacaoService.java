package br.com.checkEvents.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.checkEvents.dao.LocalizacaoRepository;
import br.com.checkEvents.model.Localizacao;

@Service
@Transactional
public class LocalizacaoService extends ServiceGeneric<Localizacao, LocalizacaoRepository> {

}
