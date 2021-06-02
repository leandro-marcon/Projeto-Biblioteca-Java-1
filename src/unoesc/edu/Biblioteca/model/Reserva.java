package unoesc.edu.Biblioteca.model;

import java.util.Date;
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
import javax.persistence.ManyToOne;
import javax.persistence.Table;



@SuppressWarnings("serial")
@Entity
@Table(name = "Reservas")
public class Reserva {

	@Id
	@GeneratedValue(generator = "seq_pk_reservas", strategy = GenerationType.AUTO)
	private int codigoReserva;
	
	@Column
	private Date dtInicio;
	
	@Column
	private Date dtFinal;
//	
	
	
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "Reservas_Livros", 
    joinColumns = { @JoinColumn(name = "codigoreserva") }, 
    inverseJoinColumns = { @JoinColumn(name = "codigolivro") })
	private Set<Livro> livros = new HashSet<Livro>();
	
//	
	
	@ManyToOne
	@JoinColumn(name = "codigoUser")// integer,
	private Usuario usuario;
	
	
//	
//	
//	

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	


	public Set<Livro> getLivros() {
		return livros;
	}

	public void setLivros(Set<Livro> livros) {
		this.livros = livros;
	}

	public int getCodigoReserva() {
		return codigoReserva;
	}
	
	public void setCodigoReserva(int codigoReserva) {
		this.codigoReserva = codigoReserva;
	}

	public Date getDtInicio() {
		return dtInicio;
	}

	public void setDtInicio(Date dtInicio) {
		this.dtInicio = dtInicio;
	}

	public Date getDtFinal() {
		return dtFinal;
	}

	public void setDtFinal(Date dtFinal) {
		this.dtFinal = dtFinal;
	}
	

}
