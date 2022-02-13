package com.ite.christianDiez.restController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ite.christianDiez.modelo.dao.EventoDao;
import com.ite.christianDiez.modelo.entityBeans.Evento;
import com.ite.christianDiez.repository.EventoRepository;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/rest/eventos")
public class EventoRestController {

	@Autowired
	EventoDao edao;
	@Autowired
	EventoRepository erepo;

	/*
	 * Nos muestra el resultado del eventos que le indiquemos
	 */
	@GetMapping("/verUno/{idEvento}")
	public Evento procUno(@PathVariable("idEvento") int idEvento) {
		return edao.verUno(idEvento);
	}

	/*
	 * Nos muestra una lista con todos los eventos activos
	 */

	@GetMapping("/activos")
	public List<Evento> procActivos() {
		return erepo.verActivos();
	}

	/*
	 * Nos muestra una lista con los eventos destacados
	 */

	@GetMapping("/destacados")
	public List<Evento> procDestacados() {
		return erepo.verDestacados();
	}

	/*
	 * Nos muestra una lista con los eventos que contengas la cadena introducida
	 * Ejemplo: Si ponemos /buscarEventos/b --> Nos muestra el evento bautizo y boda
	 * Ejemplo: Si ponemos /buscarEventos/od --> Nos muestra el evento boda
	 */

	@GetMapping("/buscarEventos/{subcadena}")
	public List<Evento> procCadena(@PathVariable("subcadena") String subcadena) {
		return erepo.buscarEventoPor(subcadena);
	}

	/*
	 * Nos manda un mensaje y da de alta en la bbdd si todo ha ido bien
	 */

	@PostMapping("/alta")
	public String procAlta(@RequestBody Evento evento) {
		return (edao.altaEvento(evento) == 1) ? "Alta realizada" : "Alta NOOO realizada";
	}

	/*
	 * Nos manda un mensaje y modifica el evento en la bbdd si todo ha ido bien
	 */

	@PutMapping("/modificar")
	public String procModi(@RequestBody Evento evento) {
		return (edao.modEvento(evento) == 1) ? "Modificacion realizada" : "Modificacion NOOO realizada";
	}

	/*
	 * Nos manda un mensaje y elimina el evento en la bbdd si todo ha ido bien
	 */

	@DeleteMapping("eliminar/{idEvento}")
	public String procElim(@PathVariable("idEvento") int idEvento) {
		return (edao.elimEvento(idEvento) == 1) ? "Evento eliminado" : "Evento NOOO eliminado";
	}

	/*
	 * Nos muestra un mensaje con las plazas disponibles 
	 */
	@GetMapping("plazasQuedan/{idEvento}")
	public String procPlazas(@PathVariable("idEvento") int idEvento) {
		return "quedan_plazas: " + erepo.plazasDisponibles(idEvento);
	}

}
