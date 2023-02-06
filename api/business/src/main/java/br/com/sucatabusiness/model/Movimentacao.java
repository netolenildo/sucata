package br.com.sucatabusiness.model;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
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
@Table(schema = "public", name = "movimentacao")
public class Movimentacao {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_movimentacao", nullable = false)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "id_usuario", nullable = false)
	private Usuario usuario;

	@OneToMany(mappedBy = "movimentacao", cascade = CascadeType.ALL)
	private List<MovimentacaoMaterial> materiais;

	@Column(name = "tipo_movimentacao")
	@Enumerated(EnumType.ORDINAL)
	private TipoMovimentacao tipoMovimentacao;

	@Column(name = "data_hora_movimentacao")
	private LocalDateTime dataHora;

	@Column(name = "valor_total")
	private Double valorTotal;
}
