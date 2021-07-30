package org.generation.lojagames.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "tb_categoria")
public class Categoria {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@NotBlank
	@Size(min = 1, max = 20)
	private String tipo;
	
	@NotBlank
	@Size(min = 1, max= 255)
	private String descricao;
	
	// cascade+remove: Se tiver um delete da tabela, fica o trace so que esteve lá, move pra 'deletados'
	@OneToMany(mappedBy = "categoria",cascade = CascadeType.REMOVE) // 'categoria' não tem chave estrangeira de 'produtos', por isso precisa do map
	private List<Produtos> produtos; // como é o 'many', recebe uma lista de produtos

	
	
	public List<Produtos> getProdutos() { //não esquecer desse getter and setter
		return produtos;
	}

	public void setProdutos(List<Produtos> produtos) {
		this.produtos = produtos;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
}
