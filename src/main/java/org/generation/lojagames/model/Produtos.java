package org.generation.lojagames.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "tb_produto")
public class Produtos {

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private long id;
	
	@NotBlank
	@Size(min = 1, max = 100)
	private String nome;
	
	@Min(1) // valor minimo 1, mesmo que fosse de graça, teria que colocar zero. Se a pessoa colocasse -15, ela ia ganhar 15 reais e o jogo
	private double preco; // não existe numero null, é zero
	
	private boolean disponivel;

									   //manytoone cria uma chave estrangeira, o cateogia_id, é o inner join, já traz tudo
	@ManyToOne 					       // o ultimo nome da anotação sempre equivale a quantidade de dados que estou recebendo (linha 32) = 1 categoria para muitos produtos 
	@JsonIgnoreProperties("categoria") // em produtos tem categoria, e em categoria tem produtos, looping infinito... precisa excluir categoria depois de mapear
	private Categoria categoria;      // o tipo do dado deve ser o mesmo nome da classe que eu quero relacionar
	
	
	
	public Categoria getCategoria() { //não esquecer do getters and setters da categoria
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public boolean isDisponivel() {
		return disponivel;
	}

	public void setDisponivel(boolean disponivel) {
		this.disponivel = disponivel;
	}
	
}




