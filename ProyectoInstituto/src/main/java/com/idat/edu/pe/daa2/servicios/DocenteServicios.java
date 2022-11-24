package com.idat.edu.pe.daa2.servicios;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.idat.edu.pe.daa2.modelo.Docente;
import com.idat.edu.pe.daa2.repositorios.DocenteRepositorio;

@Service
@Transactional

public class DocenteServicios {

	@Autowired
	public DocenteRepositorio docenteRepositorio;
	
	public DocenteServicios() {
		
	}
	
	public Docente crear (Docente docente) {
		return docenteRepositorio.save(docente);
	}
	
	public List<Docente> buscarTodo(){
		return (ArrayList<Docente>) docenteRepositorio.findAll();
	}
	
	public Docente buscarPorId(Integer id) {
		return docenteRepositorio.findById(id).get();
	}
	
	public Docente actualizar(Docente docenteActualizar) {
		

		Docente docenteActual = docenteRepositorio.findById(docenteActualizar.getIdDocente()).get();
		
		docenteActual.setIdDocente(docenteActualizar.getIdDocente());
		docenteActual.setNombreDocente(docenteActualizar.getNombreDocente());
		docenteActual.setEdadDocente(docenteActualizar.getEdadDocente());
		docenteActual.setCorreoDocente(docenteActualizar.getCorreoDocente());
		
		Docente docenteActualizado = docenteRepositorio.save(docenteActual);
		return docenteActualizado;
	}
	
	
	public void eliminarDocente(Integer id) {
		docenteRepositorio.deleteById(id);
	}
	
	
	
public void actualizar(int id,Docente docente) {
		
		
		Docente docenteActual =docenteRepositorio.findById(id).get();
		
		
		docenteActual.setNombreDocente(docente.getNombreDocente());
		docenteActual.setEdadDocente(docente.getEdadDocente());
		docenteActual.setCorreoDocente(docente.getCorreoDocente());
		docenteActual.setProfesion(docente.getProfesion());
		
		docenteRepositorio.save(docenteActual);
		
	}

}
