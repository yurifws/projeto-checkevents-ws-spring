package br.com.checkEvents.controller;

import java.util.Collections;
import java.util.Map;
import java.util.Random;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.checkEvents.model.Usuario;
import br.com.checkEvents.service.UsuarioService;

@RestController
@RequestMapping(value = "/usuario")
public class UsuarioController extends ControllerGeneric<Usuario, UsuarioService> {	
	
	@RequestMapping(value = "/verificarLogin", method = RequestMethod.GET)
	public ResponseEntity<Map<String, Boolean>> verificarLogin(@RequestParam("login")String login){
		return new ResponseEntity<>(Collections.singletonMap("valido", this.service.verificarLogin(login)), HttpStatus.OK);
	}
	
	@ResponseBody
	@RequestMapping(value = "/logar", method = RequestMethod.GET)
	public ResponseEntity<Usuario> logar(
			@RequestParam("login")String login,
			@RequestParam("senha")String senha){
		return new ResponseEntity<Usuario>(this.service.logar(login, senha), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/testar", method = RequestMethod.GET)
	public ResponseEntity<String> testar(){
		try {
			Usuario usuario;
			for (int i = 0; i < 10; i++) {
				usuario = new Usuario();
				usuario.setLogin(String.valueOf(i+1));
				usuario.setSenha(String.valueOf(i+1));
				usuario.setNome(String.valueOf(i+1));
				usuario.setSexo("M");
				usuario.setSobrenome(String.valueOf(i+1));
				usuario.setTipoUsuario(new Random().nextBoolean());
				((UsuarioService) this.service).salvar(usuario);
			}
			return new ResponseEntity<String>("Foi", HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>("N foi: " + e.getMessage(), HttpStatus.OK);
		}
	}
	
}
