package br.com.sucataweb.controller;

import br.com.sucatabusiness.model.Usuario;
import br.com.sucatabusiness.service.IUsuarioService;
import br.com.sucataweb.form.UsuarioForm;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UsuarioController {

	private final IUsuarioService service;

	@PostMapping("/usuario")
	public ResponseEntity<Usuario> cadastrarUsuario(@RequestBody UsuarioForm usuario){
		return ResponseEntity.ok(service.salvar(new Usuario()));
	}
}
