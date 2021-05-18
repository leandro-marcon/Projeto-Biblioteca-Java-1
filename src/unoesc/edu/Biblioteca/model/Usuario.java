package unoesc.edu.Biblioteca.model;



import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@SuppressWarnings("serial")
@Entity
@Table(name = "Usuarios")

public class Usuario {
	
	@Id
	@GeneratedValue(generator = "seq_pk_usuarios", strategy = GenerationType.AUTO)
	private int codigoUser;
	
	@Column
	private String nome;
	
	@Column
	private String email;
	
	@Column
	private Date dtNascimento;
	
//	public Usuario(int codigoUser, String nome, Date dtNascimento) {
//		this.codigoUser = codigoUser;
//		this.nome = nome;
//		//this.dtNascimento = dtNascimento;
//	}
	
	public int getCodigoUser() {
		return codigoUser;
	}

	public void setCodigoUser(int codigoUser) {
		this.codigoUser = codigoUser;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getDtNascimento() {
		return dtNascimento;
	}

	public void setDtNascimento(Date dtNascimento) {
		this.dtNascimento = dtNascimento;
	}	

}


