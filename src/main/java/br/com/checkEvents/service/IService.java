package br.com.checkEvents.service;

import java.util.List;

import br.com.checkEvents.model.BaseEntity;

public interface IService<T extends BaseEntity> {
	
	public T buscar(int id);
	public T salvar(T entidade);
	public T alterar(T entidade);
	public List<T> buscarTodos();
	public void deletar(int id);
	public void deletar(T entidade);
	public Long qtdRegistro();	
	public String testeHello();
	
}
