package br.com.sucatabusiness.repository;

import br.com.sucatabusiness.model.Usuario;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends CrudRepository<Usuario, Long> {

	Usuario findUsuarioByLogin(String login);
}
