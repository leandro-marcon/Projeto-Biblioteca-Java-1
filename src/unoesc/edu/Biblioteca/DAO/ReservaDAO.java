package unoesc.edu.Biblioteca.DAO;

import java.util.List;

import unoesc.edu.Biblioteca.model.Reserva;
import unoesc.edu.Biblioteca.model.Usuario;

public interface ReservaDAO {
	
	List<Reserva> getallReservas(); 		// retorna todos os usuarios
	Reserva getReservaById(int id); 		// retorna um usuarios com base no id
	void insertReserva(Reserva user); 		// Insere usuarios
	boolean updateReserva(Reserva user); 	// Atualiza 
	boolean deleteReserva(int id);			// Exclui

}


