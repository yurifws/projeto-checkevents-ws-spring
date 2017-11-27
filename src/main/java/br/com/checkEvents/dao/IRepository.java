package br.com.checkEvents.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import br.com.checkEvents.model.BaseEntity;

public interface IRepository<T extends BaseEntity> extends CrudRepository<T, Integer> {

	List<T> findAll();
	
}
