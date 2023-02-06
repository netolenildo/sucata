package br.com.sucatabusiness.service.impl;

import java.util.List;
import java.util.Objects;

import br.com.sucatabusiness.exceptions.NegocioException;
import br.com.sucatabusiness.model.Material;
import br.com.sucatabusiness.repository.MaterialRepository;
import br.com.sucatabusiness.service.IMaterialService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MaterialService implements IMaterialService {

	private final MaterialRepository repository;

	@Override public Material salvar(Material material) {
		if (Objects.nonNull(repository.findMaterialByDescricao(material.getDescricao()))) {
			throw new NegocioException("Material já cadastrado.");
		}
		return repository.save(material);
	}

	@Override public Material alterar(Material material) {
		Material materialDb = repository.findMaterialByDescricao(material.getDescricao());
		if (Objects.nonNull(materialDb) && !materialDb.getId().equals(material.getId())) {
			throw new NegocioException("Já existe um matérial com o nome informado.");
		}
		return repository.save(material);
	}

	@Override public List<Material> findAll() {
		return repository.findAllByOrOrderByDescricaoAsc();
	}

	@Override public List<Material> findByDescricao(String descricao) {
		return repository.findMateriaisByDescricao(descricao);
	}

	@Override public void remover(Long id) {
		if (repository.existeAlgumaMovimentacaoMaterial(id)) {
			throw new NegocioException("Material não pode ser removido, pois já existem movimentações cadastradas para o mesmo");
		}
		repository.deleteById(id);
	}
}
