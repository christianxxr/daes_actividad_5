package com.ite.christianDiez.modelo.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ite.christianDiez.modelo.entityBeans.Evento;
import com.ite.christianDiez.repository.EventoRepository;

@Repository
public class EventoDaoImpl implements EventoDao {

	@Autowired
	EventoRepository erepo;

	@Override
	public Evento verUno(int idEvento) {
		// TODO Auto-generated method stub
		return erepo.findById(idEvento).orElse(null);
	}

	@Override
	public int altaEvento(Evento evento) {
		// TODO Auto-generated method stub
		if (verUno(evento.getIdEvento()) == null) {
			erepo.save(evento);
			return 1;
		} else
			return 0;
	}

	@Override
	public int modEvento(Evento evento) {
		// TODO Auto-generated method stub
		if (verUno(evento.getIdEvento()) != null) {
			erepo.save(evento);
			return 1;
		} else
			return 0;
	}

	@Override
	public int elimEvento(int idEvento) {
		// TODO Auto-generated method stub
		if (verUno(idEvento) != null) {
			erepo.deleteById(idEvento);
			return 1;
		} else
			return 0;
	}

}
