package br.com.checkEvents.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.checkEvents.dao.ContatoRepository;
import br.com.checkEvents.dao.UsuarioRepository;
import br.com.checkEvents.model.Usuario;

@Service
@Transactional
public class UsuarioService extends ServiceGeneric<Usuario, UsuarioRepository> {

	@Autowired
	private ContatoRepository contatoRepository;
	
	public boolean verificarLogin(String login){
		return this.repository.findByLogin(login).size() > 0;
	}
	
	@Override
	public Usuario salvar(Usuario entidade) {
		return super.salvar(entidade);
	}
	
	@Override
	public Usuario alterar(Usuario entidade) {
		//entidade = validarUsuario(entidade);
		
		return super.alterar(entidade);
	}
	
	public Usuario logar(String login, String senha){
		return this.repository.findByLoginAndSenha(login, senha);
	}
	
	protected Usuario validarUsuario(Usuario entidade){
		if(entidade.getContato().getId() == null || (entidade.getContato().getId() != null && entidade.getContato().getId() == 0))
			entidade.setContato(contatoRepository.save(entidade.getContato()));
		
		return entidade;
	}

}
