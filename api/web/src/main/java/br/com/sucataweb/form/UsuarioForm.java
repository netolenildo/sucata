package br.com.sucataweb.form;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioForm {

	private String longin;

	private String senha;

	private String email;

	private Character sexo;
}
