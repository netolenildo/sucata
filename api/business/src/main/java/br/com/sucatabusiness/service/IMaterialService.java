package br.com.sucatabusiness.service;

import java.util.List;

import br.com.sucatabusiness.model.Material;

public interface IMaterialService {

	Material salvar(Material material);

	Material alterar(Material material);

	List<Material> findAll();

	List<Material> findByDescricao(String descricao);

	void remover(Long id);


}
