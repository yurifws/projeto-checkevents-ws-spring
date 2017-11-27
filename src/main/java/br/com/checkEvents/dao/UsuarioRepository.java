package br.com.checkEvents.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.checkEvents.model.Usuario;

@Repository
public interface UsuarioRepository extends IRepository<Usuario>{
	
	//List<Usuario> save(List<Usuario> entities);
	//void delete(List<Usuario> entities);
	List<Usuario> findByLogin(String login);
	Usuario findByLoginAndSenha(String login, String senha);
	Usuario findByNomeAndSobrenome(String nome, String sobrenome);
		
}
