package br.com.checkEvents.dao;

import java.util.List;

import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;

import br.com.checkEvents.model.Evento;

public interface EventoRepository extends IRepository<Evento> {

	public List<Evento> findByDescricao(String descricao);

//	@Procedure("calcular_distancia")
//	public List<Evento> buscarPorLocalizacao(@Param("km") double km, @Param("latCentral") double latCentral, @Param("lngCentral") double lngCentral);	
	
//	public Evento findLocalizacaoByLatitudeAndLongitude(double latitude, double longitude);
}
