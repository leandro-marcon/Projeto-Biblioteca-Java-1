package unoesc.edu.Biblioteca.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name = "Livros")
public class Livro {
	
	@Id
	@GeneratedValue(generator = "seq_pk_livros", strategy = GenerationType.AUTO)
	private int codigoLivro;
	
	@Column
	private String titulo;
	
	@Column
	private String autor;
	
	@Column
	private int anoPublic;

	public int getCodigoLivro() {
		return codigoLivro;
	}

	public void setCodigoLivro(int codigoLivro) {
		this.codigoLivro = codigoLivro;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public int getAnoPublic() {
		return anoPublic;
	}

	public void setAnoPublic(int anoPublic) {
		this.anoPublic = anoPublic;
	}
	
	

}
