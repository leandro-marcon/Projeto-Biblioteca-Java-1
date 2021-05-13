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
	
	@ManyToMany(mappedBy = "Livros")
	
	@Id
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "codigoUser")// integer,
	Usuario usuario;
	
	
	
	
}
