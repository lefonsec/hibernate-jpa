package leo.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name= "tb_livro")
public class Livro implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name= "id_livro")
	private Integer id;
	
	@Column(name = "ds_titulo",nullable = false)
	private String titulo;
	
	@Column(name = "ds_isbn",nullable = false)
	private String isbn;
	
	@Column(name = "ds_autor",nullable = false)
	private String autor;
	
	@Column(name = "dt_aquisicao",nullable = false)
	private LocalDateTime aquisicao;
	
	@ManyToOne
	@JoinColumn(name = "id_localizacao", nullable = false)
	private Localizacao localizacao; 
	
	@ManyToOne
	@JoinColumn(name = "id_categoria")
	private CategoriaLivro categoria;

	public Livro() {
	}

	public Livro(String titulo, String isbn, String autor, LocalDateTime aquisicao, Localizacao localizacao,
			CategoriaLivro categoria) {
		this.titulo = titulo;
		this.isbn = isbn;
		this.autor = autor;
		this.aquisicao = aquisicao;
		this.localizacao = localizacao;
		this.categoria = categoria;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public LocalDateTime getAquisicao() {
		return aquisicao;
	}

	public void setAquisicao(LocalDateTime aquisicao) {
		this.aquisicao = aquisicao;
	}

	public Localizacao getLocalizacao() {
		return localizacao;
	}

	public void setLocalizacao(Localizacao localizacao) {
		this.localizacao = localizacao;
	}

	public CategoriaLivro getCategoria() {
		return categoria;
	}

	public void setCategoria(CategoriaLivro categoria) {
		this.categoria = categoria;
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
		Livro other = (Livro) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	
	
	

}
