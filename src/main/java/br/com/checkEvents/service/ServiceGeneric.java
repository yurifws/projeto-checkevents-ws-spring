package br.com.checkEvents.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.checkEvents.dao.IRepository;
import br.com.checkEvents.model.BaseEntity;

public abstract class ServiceGeneric<T extends BaseEntity, Repository extends IRepository<T>> implements IService<T> {

	@Autowired
	protected Repository repository;
	
	public T buscar(int id) {
		return repository.findOne(id);
	}

	
	public void deletar(int id) {
		repository.delete(id);		
	}

	
	public void deletar(T entidade) {
		repository.delete(entidade);		
	}

	
	public Long qtdRegistro() {
		return repository.count();
	}

	
	public T salvar(T entidade) {
		return repository.save(entidade);
	}
	
	
	public T alterar(T entidade) {
		return repository.save(entidade);
	}

	
	public List<T> buscarTodos() {
		return repository.findAll();
	}
	
	public String testeHello(){
		return "hello World";
	}
	
}
