package br.com.checkEvents.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.checkEvents.dao.ContatoRepository;
import br.com.checkEvents.dao.EnderecoRepository;
import br.com.checkEvents.dao.EventoRepository;
import br.com.checkEvents.dao.LocalizacaoRepository;
import br.com.checkEvents.dao.TipoEventoRepository;
import br.com.checkEvents.model.Evento;

@Service
@Transactional
public class EventoService extends ServiceGeneric<Evento, EventoRepository> {

	protected final double R = 6372.8;    

	@Autowired
	private ContatoRepository contatoRepository;

	@Autowired
	private EnderecoRepository enderecoRepository;

	@Autowired
	private LocalizacaoRepository localizacaoRepository;

	@Autowired
	private TipoEventoRepository tipoEventoRepository;

	@Override
	public Evento salvar(Evento entidade) {
		//entidade = validarEvento(entidade);
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			String dataFormatada = sdf.format(new Date());
			entidade.setDataInicio(sdf.parse(dataFormatada));
			dataFormatada = sdf.format(new Date());
			entidade.setDataTermino(sdf.parse(dataFormatada));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return super.salvar(entidade);
	}

	@Override
	public Evento alterar(Evento entidade) {
		//entidade = validarEvento(entidade);	
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			String dataFormatada = sdf.format(new Date());
			entidade.setDataInicio(sdf.parse(dataFormatada));
			dataFormatada = sdf.format(new Date());
			entidade.setDataTermino(sdf.parse(dataFormatada));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return super.salvar(entidade);
	}

	public List<Evento> buscarPorDesc(String desc){
		return this.repository.findByDescricao(desc);		
	}

	public List<Evento> buscarPorDistancia(double km, double latCentral, double lngCentral){
		List<Evento> listaEvento = this.repository.findAll();
		//				.stream()
		//				.filter(evento -> haversine(latCentral, lngCentral, evento.getLocalizacao().getLatitude(), evento.getLocalizacao().getLongitude()) <= km)
		//				.collect(Collectors.toList());
		List<Evento> listaAux = new ArrayList<>();
		for (Evento evento : listaEvento) {
			if(haversine(latCentral, lngCentral, evento.getLocalizacao().getLatitude(), evento.getLocalizacao().getLongitude()) <= km)
				listaAux.add(evento);
		}
		return listaAux;
	}

	protected double haversine(double lat1, double lon1, double lat2, double lon2) {
		double dLat = Math.toRadians(lat2 - lat1);
		double dLon = Math.toRadians(lon2 - lon1);
		lat1 = Math.toRadians(lat1);
		lat2 = Math.toRadians(lat2);

		double a = Math.pow(Math.sin(dLat / 2),2) + Math.pow(Math.sin(dLon / 2),2) * Math.cos(lat1) * Math.cos(lat2);
		double c = 2 * Math.asin(Math.sqrt(a));
		return R * c;
	}

	protected Evento validarEvento(Evento entidade){
		if(entidade.getContato().getId() == null || entidade.getContato().getId() == 0)
			entidade.setContato(contatoRepository.save(entidade.getContato()));

		if(entidade.getEndereco().getId() == null || entidade.getEndereco().getId() == 0)
			entidade.setEndereco(enderecoRepository.save(entidade.getEndereco()));

		if(entidade.getLocalizacao().getId() == null || entidade.getLocalizacao().getId() == 0)
			entidade.setLocalizacao(localizacaoRepository.save(entidade.getLocalizacao()));

		if(entidade.getTipoEvento().getId() == null || entidade.getTipoEvento().getId() == 0)
			entidade.setTipoEvento(tipoEventoRepository.save(entidade.getTipoEvento()));

		return entidade;
	}

	//	public List<Evento> buscarPorDistancia(double km, double latCentral, double lngCentral){
	//		List<Evento> listaEvento = this.buscarTodos();
	//				
	//		for (Evento evento : listaEvento) {
	//            if(haversine(latCentral, lngCentral, evento.getLocalizacao().getLatitude(), evento.getLocalizacao().getLongitude()) > km){
	//                listaEvento.remove(evento);
	//            }
	//        }
	//        return listaEvento;
	//    }
	//    
	//    
	//    // Oi Rodrigo passei aqui Hahaahahahahahhahahhahahaha    
	//    protected double haversine(double lat1, double lon1, double lat2, double lon2) {
	//        double dLat = Math.toRadians(lat2 - lat1);
	//        double dLon = Math.toRadians(lon2 - lon1);
	//        lat1 = Math.toRadians(lat1);
	//        lat2 = Math.toRadians(lat2);
	// 
	//        double a = Math.pow(Math.sin(dLat / 2),2) + Math.pow(Math.sin(dLon / 2),2) * Math.cos(lat1) * Math.cos(lat2);
	//        double c = 2 * Math.asin(Math.sqrt(a));
	//        return R * c;
	//    }
	public Evento buscarPorLatLgn(double latitude, double longitude){
		Evento eventoPesquisado = new Evento();
		List<Evento> listaEvento = this.repository.findAll();
		for (Evento evento : listaEvento) {
			if(evento.getLocalizacao().getLatitude() == latitude && evento.getLocalizacao().getLongitude() == longitude)
				eventoPesquisado = evento;
				
		}
		return eventoPesquisado;
	}

}
