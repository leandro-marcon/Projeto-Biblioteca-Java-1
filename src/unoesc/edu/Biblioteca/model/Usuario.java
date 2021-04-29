package unoesc.edu.Biblioteca.model;

import java.util.Date;

public class Usuario {
	private int codigoUser;
	private String nome;
	private Date dtNascimento;
	
	public Usuario(int codigoUser, String nome, Date dtNascimento) {
		this.codigoUser = codigoUser;
		this.nome = nome;
		this.dtNascimento = dtNascimento;
	}

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

	public Date getDtNascimento() {
		return dtNascimento;
	}

	public void setDtNascimento(Date dtNascimento) {
		this.dtNascimento = dtNascimento;
	}
	
	

	


}


