package unoesc.edu.Biblioteca.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
//	//@ManyToMany(mappedBy = "Livros")
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
