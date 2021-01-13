 	 	 package leo.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tb_categoria_livro")
public class CategoriaLivro implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_categoria_livro")
	private Integer id;
	
	@Column(name = "ds_nome", nullable = false)
	private String nome;
	
	@ManyToOne
	@JoinColumn(name = "id_categoria_pai")
	private CategoriaLivro pai;
	
	@OneToMany(mappedBy = "pai")
	private List<CategoriaLivro> filha;
	
	@OneToMany(mappedBy = "categoria")
	private List<Livro> livros;


	public CategoriaLivro() {
	}

	public CategoriaLivro(String nome, CategoriaLivro pai) {
		this.nome = nome;
		this.pai = pai;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public CategoriaLivro getPai() {
		return pai;
	}

	public void setPai(CategoriaLivro pai) {
		this.pai = pai;
	}

	public List<CategoriaLivro> getFilha() {
		return filha;
	}

	public void setFilha(List<CategoriaLivro> filha) {
		this.filha = filha;
	}
	public List<Livro> getLivros() {
		return livros;
	}

	public void setLivros(List<Livro> livros) {
		this.livros = livros;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CategoriaLivro other = (CategoriaLivro) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	
	

	
	
	
	
}
