package com.idat.edu.pe.daa2.servicios;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.idat.edu.pe.daa2.modelo.Profesion;
import com.idat.edu.pe.daa2.repositorios.ProfesionRepositorio;

@Service
@Transactional

public class ProfesionServicios {

	@Autowired
	public ProfesionRepositorio profesionRepositorio;
	
	public ProfesionServicios() {
		
	}
	
	public Profesion crear (Profesion profesion ) {
		return profesionRepositorio.save(profesion);
	}
	
	public List<Profesion> buscarTodo(){
		return (ArrayList<Profesion>) profesionRepositorio.findAll();
	}
	
	public Profesion buscarPorId(Integer id) {
		return profesionRepositorio.findById(id).get();
	}
	
	public Profesion actualizar(Profesion profesionActualizar) {
		

		Profesion profesionActual = profesionRepositorio.findById(profesionActualizar.getIdProfesion()).get();
		
		profesionActual.setIdProfesion(profesionActualizar.getIdProfesion());
		profesionActual.setNombreProfesion(profesionActualizar.getNombreProfesion());
		profesionActual.setCentroEstudio(profesionActualizar.getCentroEstudio());
		
		Profesion profesionActualizado = profesionRepositorio.save(profesionActual);
		return profesionActualizado;
	}
	
	
	public void eliminarProfesion(Integer id) {
		profesionRepositorio.deleteById(id);
	}
	
	
	
public void actualizar(int id,Profesion profesion) {
		
		
		Profesion profesionActual =profesionRepositorio.findById(id).get();
		
		
		profesionActual.setNombreProfesion(profesion.getNombreProfesion());
		profesionActual.setCentroEstudio(profesion.getCentroEstudio());
		
		profesionRepositorio.save(profesionActual);
		
	}

}
