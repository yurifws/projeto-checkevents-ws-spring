package br.com.checkEvents.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.checkEvents.model.BaseEntity;
import br.com.checkEvents.service.IService;

public abstract class ControllerGeneric<T extends BaseEntity, Service extends IService<T>> implements IController<T> {

	@Autowired
	protected Service service;
	
	@ResponseBody
	@RequestMapping(value = "/hello", method = RequestMethod.GET)
	public ResponseEntity<String> testeHello(){
		return new ResponseEntity<String>(this.service.testeHello(), HttpStatus.OK);
	}
	
	@ResponseBody
	@RequestMapping(value = "/buscarTodos", method = RequestMethod.GET)
	public ResponseEntity<List<T>> buscarTodos(){
		return new ResponseEntity<List<T>>(service.buscarTodos(), HttpStatus.OK);
	}
	
	@ResponseBody
	@RequestMapping(value = "/buscar", method = RequestMethod.GET)
	public ResponseEntity<T> buscar(@RequestParam("id") int id){
		return new ResponseEntity<T>(service.buscar(id), HttpStatus.OK);
	}
	
	@ResponseBody
	@RequestMapping(value = "/incluir", method = RequestMethod.PUT)
	public ResponseEntity<T> incluir(@RequestBody T entidade){
		return new ResponseEntity<T>(service.salvar(entidade), HttpStatus.OK);		
	}
	
	@ResponseBody
	@RequestMapping(value = "/atualizar", method = RequestMethod.PUT)
	public ResponseEntity<T> alterar(@RequestBody T entidade){	
		return new ResponseEntity<T>(service.alterar(entidade), HttpStatus.OK);		
	}
	
	@RequestMapping(value = "/deletar", method = RequestMethod.DELETE)
	public void deletar(@RequestParam("id")int id) {
		service.deletar(id);
	}

//	@RequestMapping(value = "/deletar", method = RequestMethod.DELETE)
//	public void deletar(@RequestParam("entidade")T entidade) {
//		service.deletar(entidade);
//	}
	
	@ResponseBody
	@RequestMapping(value = "/total", method = RequestMethod.GET)
	public ResponseEntity<Long> qtdRegistro() {
		return new ResponseEntity<Long>(service.qtdRegistro(), HttpStatus.OK);
	}

	
}
