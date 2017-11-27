package br.com.checkEvents.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.checkEvents.dao.TipoEventoRepository;
import br.com.checkEvents.model.TipoEvento;

@Service
@Transactional
public class TipoEventoService extends ServiceGeneric<TipoEvento, TipoEventoRepository> {

}
