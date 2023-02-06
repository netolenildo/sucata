package br.com.sucatabusiness.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(schema = "public", name = "material")
public class Material {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_material", nullable = false)
	private Long id;

	@Column(nullable = false)
	private String descricao;

	@Column(nullable = false)
	private Double valorUnidade;

}
