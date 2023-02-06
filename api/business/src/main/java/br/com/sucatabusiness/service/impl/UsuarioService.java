package br.com.sucatabusiness.service.impl;

import java.util.Objects;

import br.com.sucatabusiness.exceptions.NegocioException;
import br.com.sucatabusiness.model.Usuario;
import br.com.sucatabusiness.repository.UsuarioRepository;
import br.com.sucatabusiness.service.IUsuarioService;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService implements IUsuarioService {

	private final UsuarioRepository repository;

	public UsuarioService(UsuarioRepository repository) {
		this.repository = repository;
	}

	@Override public Usuario salvar(Usuario usuario) {
		Usuario usuarioDb = repository.findUsuarioByLogin(usuario.getLogin());
		if (Objects.nonNull(usuarioDb) && !usuarioDb.getId().equals(usuario.getId())) {
			throw new NegocioException("Usuário já cadastrado.");
		}

		return repository.save(usuario);
	}
}
