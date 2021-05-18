package unoesc.edu.Biblioteca.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
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
	
	//@ManyToMany(fetch = FetchType.EAGER)
	//@JoinTable(name = "Reservas_Livros", 
    //joinColumns = { @JoinColumn(name = "codigoReserva") }, 
    //inverseJoinColumns = { @JoinColumn(name = "codigoReserva") })
 	//private Set<Reserva> reserva = new HashSet<Reserva>();
	
	
	
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
