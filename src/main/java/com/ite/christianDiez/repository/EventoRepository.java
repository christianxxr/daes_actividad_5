package com.ite.christianDiez.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.PathVariable;

import com.ite.christianDiez.modelo.entityBeans.Evento;

public interface EventoRepository extends JpaRepository<Evento, Integer> {

	/*
	 * Muestra el evento que empieze por la cadena indicada
	 */
	@Query("select e from Evento e where e.nombre like %:nombre%")
	List<Evento> buscarEventoPor(@PathVariable("nombre") String nombre);

	/*
	 * Nos muestra los eventos que tengan el estado activo
	 */
	@Query("select e from Evento e where e.estado='ACTIVO'")
	List<Evento> verActivos();

	/*
	 * Nos muestra los eventos destacados
	 */
	@Query("select e from Evento e where e.destacado='s'")
	List<Evento> verDestacados();

	/*
	 * Nos muestra el resultado de las plazas disponibles que nos quedan
	 */
	@Query("select e.aforoMaximo-SUM(r.cantidad) from Reserva r,Evento e where e.idEvento = r.evento.idEvento and e.idEvento=?1")
	String plazasDisponibles(@PathVariable("idEvento") int idEvento);

}
