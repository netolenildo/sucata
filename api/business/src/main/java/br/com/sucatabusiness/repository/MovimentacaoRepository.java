package br.com.sucatabusiness.repository;

import br.com.sucatabusiness.model.Movimentacao;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovimentacaoRepository extends CrudRepository<Movimentacao, Long> {
}
