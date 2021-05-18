package unoesc.edu.Biblioteca.DAO;

import java.util.List;

import unoesc.edu.Biblioteca.model.Livro;

public interface LivroDAO {
	
	List<Livro> getallLivros(); 		// retorna todos os usuarios
	Livro getLivroById(int id); 		// retorna um usuarios com base no id
	void insertLivro(Livro user); 		// Insere usuarios
	boolean updateLivro(Livro user); 	// Atualiza 
	boolean deleteLivro(int id);			// Exclui

}
