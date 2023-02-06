package br.com.sucatabusiness.repository;

import java.util.List;
import br.com.sucatabusiness.model.Material;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface MaterialRepository extends CrudRepository<Material, Long> {

	Material findMaterialByDescricao(String descricao);

	List<Material> findAllByOrOrderByDescricaoAsc();

	@Query("SELECT m FROM Material m WHERE m.descricao ILIKE %:descricao% ORDER BY m.descricao")
	List<Material> findMateriaisByDescricao(@Param("descricao") String descriacao);

	@Query("SELECT COUNT(mv) > 0 FROM Movimentacao mv JOIN mv.materiais mm JOIN mm.material mt WHERE mt.id = :idMaterial")
	Boolean existeAlgumaMovimentacaoMaterial(@Param("idMaterial") Long idMaterial);
}
