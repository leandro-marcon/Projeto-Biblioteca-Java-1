package unoesc.edu.Biblioteca.controller;

import java.io.IOException;

import java.lang.management.MemoryType;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import javax.xml.crypto.dsig.spec.ExcC14NParameterSpec;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sun.jdi.Method;

import unoesc.edu.Biblioteca.DAO.ReservaDAO;
import unoesc.edu.Biblioteca.model.Reserva;


@Controller
public class ControllerReserva {

	@Autowired
	private ReservaDAO ReservaDao;

	@RequestMapping(path = "/reserva", method = RequestMethod.GET)
	public String acessoReserva(Model model, HttpSession session) {
		System.out.println("Chamou Reserva");

		List<Reserva> listaReservas = this.ReservaDao.getallReservas();

		model.addAttribute("listaReservas", listaReservas);
		model.addAttribute("reserva", new Reserva());

		return "reservaCrud";
	}

	@RequestMapping(path = "reservaSave", method = RequestMethod.POST)
	public String ReservaSave(@ModelAttribute("Reserva") Reserva user, HttpSession session, Model model) {
		List listaReservas = (LinkedList<Reserva>) session.getAttribute("listaReserva");

		if (user.getCodigoReserva() == 0) {
			this.ReservaDao.insertReserva(user);
			System.out.println("Salvou Cliente");
		} else {
			this.ReservaDao.updateReserva(user);

		}
		
		return "redirect:/reserva";

	}
	
	@RequestMapping(path = "reservaEdit/{id}", method = RequestMethod.GET)
	public String edit(@PathVariable int id, Model model, HttpSession session) {
		List listaReservas = (LinkedList<Reserva>) session.getAttribute("listaReserva");
	
		Reserva c = this.ReservaDao.getReservaById(id); //Buscar o cara a ser editado
		model.addAttribute("listaReserva", listaReservas);
		model.addAttribute("Reserva", c);
		
		
		return "reservaCrud";
		
	}
	
	
	@RequestMapping(path = "reservaDelete/{id}", method = RequestMethod.GET)
	public String delete( @PathVariable int id, Model model, HttpSession session) {
		
		this.ReservaDao.deleteReserva(id);
	
		System.out.println("Removeu");
		
		return "redirect:/reserva";
		
	}

}
