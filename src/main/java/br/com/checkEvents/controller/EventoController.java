package br.com.checkEvents.controller;

import java.util.Date;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.checkEvents.dao.ContatoRepository;
import br.com.checkEvents.dao.EnderecoRepository;
import br.com.checkEvents.dao.LocalizacaoRepository;
import br.com.checkEvents.dao.UsuarioRepository;
import br.com.checkEvents.model.Contato;
import br.com.checkEvents.model.Endereco;
import br.com.checkEvents.model.Evento;
import br.com.checkEvents.model.Localizacao;
import br.com.checkEvents.service.EventoService;

@Controller
@RequestMapping(value = "/evento")
public class EventoController extends ControllerGeneric<Evento, EventoService> {

	@ResponseBody
	@RequestMapping(value = "/buscarPorDescricao", method = RequestMethod.GET)
	public ResponseEntity<List<Evento>> buscarPorDesc(@RequestParam("desc") String desc){
		return new ResponseEntity<List<Evento>>(this.service.buscarPorDesc(desc), HttpStatus.OK);
	}
	
	@ResponseBody
	@RequestMapping(value = "/buscarPorDistancia", method = RequestMethod.GET)
	public ResponseEntity<List<Evento>> buscarPorDistancia(@RequestParam("km")  double km,
														   @RequestParam("lat") double lat,
														   @RequestParam("lng") double lng){
		return new ResponseEntity<List<Evento>>(this.service.buscarPorDistancia(km, lat, lng), HttpStatus.OK);
	}
	
	@Autowired
	private EnderecoRepository enderecoRepository;
	
	@Autowired
	private ContatoRepository contatoRepository;
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private LocalizacaoRepository localizacaoRepository;
	
	@ResponseBody
	@RequestMapping(value = "/testar", method = RequestMethod.GET)
	public ResponseEntity<String> testarEvento(){
		try {
			Evento evento;
			Localizacao localizacao;
			Contato contato;
			Endereco endereco;
			for(int i = 0; i < 10; i++){
				evento = new Evento();
				evento.setDataInicio(new Date());
				evento.setDataTermino(new Date());
				evento.setDescricao(String.valueOf(i));
				endereco = new Endereco();
				endereco.setBairro(String.valueOf(i));
				endereco.setCep(i);
				endereco.setCidade(String.valueOf(i));
				endereco.setComplemento(String.valueOf(i));
				endereco.setLogradouro(String.valueOf(i));
				endereco.setNumero(i);
				endereco.setPais(String.valueOf(i));
				endereco.setUf(String.valueOf(i));
				evento.setEndereco(enderecoRepository.save(endereco));
				contato = new Contato();
				contato.setCelular(i);
				contato.setEmail(String.valueOf(i));
				contato.setTelefone(i);
				evento.setContato(contatoRepository.save(contato));
				evento.setOrganizador(usuarioRepository.findOne(i+1));
				localizacao = new Localizacao();
				localizacao.setLatitude(new Random(1000).nextFloat() * (i+1));
				localizacao.setLongitude(new Random(1000).nextFloat() * (i+1));
				evento.setLocalizacao(localizacaoRepository.save(localizacao));
				this.service.salvar(evento);			
			}
			return new ResponseEntity<String>("foi", HttpStatus.OK);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			return new ResponseEntity<String>("deu erro: " + e.getMessage(), HttpStatus.OK);
		}
	}
	
	@ResponseBody
	@RequestMapping(value = "/buscarPorLatLng", method = RequestMethod.GET)
	public ResponseEntity<Evento> buscarPorLatLng(@RequestParam("latitude")  double latitude,
														   @RequestParam("longitude") double longitude){
		return new ResponseEntity<Evento>(this.service.buscarPorLatLgn(latitude, longitude), HttpStatus.OK);
	}
	
	
	
	
}
