package ar.edu.unlp.bd.biblio.util;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unlp.bd.biblio.error.BiblioRecordException;
import ar.edu.unlp.bd.biblio.model.Autor;
import ar.edu.unlp.bd.biblio.model.Editorial;
import ar.edu.unlp.bd.biblio.model.Libro;
import ar.edu.unlp.bd.biblio.model.Prestamo;
import ar.edu.unlp.bd.biblio.model.Reserva;
import ar.edu.unlp.bd.biblio.model.Sancion;
import ar.edu.unlp.bd.biblio.model.Socio;
import ar.edu.unlp.bd.biblio.service.LibroService;
import ar.edu.unlp.bd.biblio.service.PrestamoService;
import ar.edu.unlp.bd.biblio.service.ReservaService;
import ar.edu.unlp.bd.biblio.service.SancionService;
import ar.edu.unlp.bd.biblio.service.SocioService;

@Service
public class BiblioDataLoaderService {
	@Autowired
	private LibroService libroService;
	@Autowired
	private SocioService socioService;
	@Autowired
	private PrestamoService prestamoService;
	@Autowired
	private ReservaService reservaService;
	@Autowired
	private SancionService sancionService;
	

	@Transactional
	public String cargarDatos() {
		ArrayList<Autor> autores = new ArrayList<Autor>();
		ArrayList<Editorial> editoriales = new ArrayList<Editorial>();
		ArrayList<Libro> libros = new ArrayList<Libro>();
		ArrayList<Socio> socios = new ArrayList<Socio>();
		ArrayList<Reserva> reservas = new ArrayList<Reserva>();
		ArrayList<Prestamo> prestamos = new ArrayList<Prestamo>();
		ArrayList<Sancion> sanciones = new ArrayList<Sancion>();

		Calendar calendar = Calendar.getInstance();
		Date fecha = calendar.getTime();
		calendar.add(Calendar.DAY_OF_YEAR, 5);
		Date fecha2 = calendar.getTime();
		calendar.add(Calendar.DAY_OF_YEAR, 5);
		Date fecha3 = calendar.getTime();
		
		Autor autor = new Autor("Santiago Posteguillo", "España");
		autores.add(autor);
		autor = new Autor("Stephen King", "Estados Unidos");
		autores.add(autor);
		autor = new Autor("JRR Tolkien", "Reino Unido");
		autores.add(autor);
		autor = new Autor("Jorge Luis Borges", "Argentina");
		autores.add(autor);
		autor = new Autor("Felipe Pigna", "Argentina");
		autores.add(autor);
		autor = new Autor("Dan Brown", "Estados Unidos");
		autores.add(autor);
		
		Editorial editorial = new Editorial("Ediciones B", "Argentina");
		editoriales.add(editorial);
		editorial = new Editorial("Minotauro" , "Argentina");
		editoriales.add(editorial);
		editorial = new Editorial("La Flor" , "Argentina");
		editoriales.add(editorial);
		
		Socio socio = new Socio("José Perez");
		socios.add(socio);
		socio = new Socio("María Gomez");
		socios.add(socio);
		socio = new Socio("Paola Ponce");
		socios.add(socio);
		socio = new Socio("Manuel Moreno");
		socios.add(socio);
		socio = new Socio("Marcos Domine");
		socios.add(socio);
		socio = new Socio("Maria Aliquo");
		socios.add(socio);
		
		Libro libro = null;
		for (int i=0; i<3;i++) {
			libro = new Libro("El señor de los anillos: La comunidad del anillo", "9788373191723", "Fantasía", "Un Hobbit aventurero trata de destruir un anillo para salvar el mundo", i+1, autores.get(2), editoriales.get(1));
			libros.add(libro);
			libro = new Libro("El señor de los anillos: Las dos torres", "9780044406792", "Fantasía", "Un Hobbit aventurero trata de destruir un anillo para salvar el mundo - segunda parte", i+1, autores.get(2), editoriales.get(1));
			libros.add(libro);
			libro = new Libro("El señor de los anillos: El Retorno del Rey", "9780044406792", "Fantasía", "Un Hobbit aventurero trata de destruir un anillo para salvar el mundo - tercera parte", i+1, autores.get(2), editoriales.get(1));
			libros.add(libro);
			libro = new Libro("IT", "9789851807822", "Terror", "Un ser asesino aterroriza el pueblo de Derry", i+1, autores.get(1), editoriales.get(0));
			libros.add(libro);
			libro = new Libro("Un saco de huesos", "9789024531837", "Terror", "Un espiritu maligno acecha a un escritor deprimido", i+1, autores.get(1), editoriales.get(0));
			libros.add(libro);
			libro = new Libro("22-11-63", "9780606385220", "Fantasía", "Un maestro de escuela viaja en el tiempo para eviar el asesinato de Kennedy", i+1, autores.get(1), editoriales.get(0));
			libros.add(libro);
			libro = new Libro("El pasillo de la muerte", "9780743591676", "Fantasía", "Un preso condenado a muerte ayuda a las personas de manera inesperada", i+1, autores.get(1), editoriales.get(0));
			libros.add(libro);
			libro = new Libro("El Aleph", "9789584203212", "Fantasía", "Recopilación de los mejores cuentos de Borges", i+1, autores.get(3), editoriales.get(2));
			libros.add(libro);
			libro = new Libro("Africanus - El hijo del Cónsul", "9788868368821", "Novela Histórica", "Vida de Plubio Cornelio Escipión, uno de los mejores generales romanos", i+1, autores.get(0), editoriales.get(0));
			libros.add(libro);
			libro = new Libro("Las Legiones malditas", "9788466645485", "Novela Histórica", "Vida de Plubio Cornelio Escipión, segunda parte", i+1, autores.get(0), editoriales.get(0));
			libros.add(libro);
			libro = new Libro("Las traición de Roma", "9788498729696", "Novela Histórica", "Vida de Plubio Cornelio Escipión, tercera parte", i+1, autores.get(0), editoriales.get(0));
			libros.add(libro);
		}
		libro = new Libro("El código Da Vinci", "9780525565857", "Novela", "Un profesor de simbología debe demostrar su inocencia por un asesinato", 1, autores.get(5), editoriales.get(0));
		libros.add(libro);
		libro = new Libro("El código Da Vinci", "9780525565857", "Novela", "Un profesor de simbología debe demostrar su inocencia por un asesinato", 2, autores.get(5), editoriales.get(0));
		libros.add(libro);
		libro = new Libro("Inferno", "9780525563357", "Novela", "Un profesor de simbología debe impedir un atentado", 1, autores.get(5), editoriales.get(0));
		libros.add(libro);
		libro = new Libro("Los mitos de la historia argentina I", "9789875809475", "Historia", "Primer entrega de la saga de historia argentina", 1, autores.get(4), editoriales.get(0));
		libros.add(libro);
		libro = new Libro("Los mitos de la historia argentina II", "9789875809235", "Historia", "Segunda entrega de la saga de historia argentina", 1, autores.get(4), editoriales.get(0));
		libros.add(libro);
		libro = new Libro("Los mitos de la historia argentina II", "9789875809235", "Historia", "Segunda entrega de la saga de historia argentina", 2, autores.get(4), editoriales.get(0));
		libros.add(libro);
		
		Reserva reserva = new Reserva(fecha,socios.get(2), libros.get(28));
		reservas.add(reserva);
		reserva = new Reserva(fecha2,socios.get(0), libros.get(15));
		reservas.add(reserva);
		reserva = new Reserva(fecha3,socios.get(2), libros.get(25));
		reservas.add(reserva);
		reserva = new Reserva(fecha3,socios.get(2), libros.get(13));
		reservas.add(reserva);
		reserva = new Reserva(fecha3,socios.get(1), libros.get(5));
		reservas.add(reserva);
		
		Prestamo prestamo = new Prestamo(fecha,fecha2, socios.get(3), libros.get(8));
		prestamos.add(prestamo);
		prestamo = new Prestamo(fecha,fecha3, socios.get(2), libros.get(30));
		prestamos.add(prestamo);
		prestamo = new Prestamo(fecha,fecha3, socios.get(1), libros.get(27));
		prestamos.add(prestamo);
		prestamo = new Prestamo(fecha,fecha3, reservas.get(3));
		prestamos.add(prestamo);
		
		Sancion sancion = new Sancion(socios.get(4), prestamos.get(1), fecha2, fecha3);
		sanciones.add(sancion);
		
		try {
			for (int i=0;i<libros.size();i++) {
				libroService.addLibro(libros.get(i));
			}
			for (int i=0;i<socios.size();i++) {
				socioService.addSocio(socios.get(i));
			}
			for (int i=0;i<reservas.size();i++) {
				reservaService.addReserva(reservas.get(i));
			}
			for (int i=0;i<prestamos.size();i++) {
				prestamoService.addPrestamo(prestamos.get(i));
			}
			for (int i=0;i<sanciones.size();i++) {
				sancionService.addSancion(sanciones.get(i));
			}
			return "Datos Cargados";
		}
		catch (Exception e) {
			throw new BiblioRecordException("Insertar los datos iniciales: " + e.getMessage());
		}
	}

	@Transactional
	public String eliminarDatos() {
		try {
			sancionService.delAllSanciones();
			prestamoService.delAllPrestamos();
			reservaService.delAllReservas();
			libroService.delAllLibros();
			socioService.delAllSocios();
			return "Datos Eliminados";
		}
		catch (Exception e) {
			throw new BiblioRecordException("Eliminar los datos de la base: " + e.getMessage());
		}
	}
}
