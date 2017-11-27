package br.com.checkEvents.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;

import br.com.checkEvents.model.BaseEntity;

public interface IController<T extends BaseEntity> {

	public ResponseEntity<T> incluir(T entidade);
	public ResponseEntity<T> alterar(T entidade);
	public ResponseEntity<T> buscar(int id);
	public ResponseEntity<List<T>> buscarTodos();
	public void deletar(int id);
	//public void deletar(T entidade);
	public ResponseEntity<Long> qtdRegistro();	
	public ResponseEntity<String> testeHello();
	
}
