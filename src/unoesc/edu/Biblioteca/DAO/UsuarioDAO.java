package unoesc.edu.Biblioteca.DAO;

import java.util.List;

import unoesc.edu.Biblioteca.model.Usuario;


public interface UsuarioDAO {
	
	List<Usuario> getallUsuarios(); 		// retorna todos os usuarios
	Usuario getUsuarioById(int id); 		// retorna um usuarios com base no id
	void insertUsuario(Usuario user); 		// Insere usuarios
	boolean updateUsuario(Usuario user); 	// Atualiza 
	boolean deleteUsuario(int id);			// Exclui

}
