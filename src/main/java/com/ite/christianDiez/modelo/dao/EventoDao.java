package com.ite.christianDiez.modelo.dao;

import com.ite.christianDiez.modelo.entityBeans.Evento;

public interface EventoDao {

	Evento verUno(int idEvento);

	int altaEvento(Evento evento);

	int modEvento(Evento evento);

	int elimEvento(int idEvento);

}
