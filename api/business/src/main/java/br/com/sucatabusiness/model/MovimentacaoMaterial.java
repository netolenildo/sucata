package br.com.sucatabusiness.model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
@Table(schema = "public", name = "movimentacao_material")
public class MovimentacaoMaterial {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_movimentacao_material", nullable = false)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "id_material", nullable = false)
	private Material material;

	@ManyToOne
	@JoinColumn(name = "id_movimentacao", nullable = false)
	private Movimentacao movimentacao;

	@Column
	private Double peso;

	@Column
	private Integer quantidade;
}
