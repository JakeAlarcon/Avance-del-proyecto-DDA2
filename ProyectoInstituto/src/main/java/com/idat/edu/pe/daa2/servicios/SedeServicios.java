package com.idat.edu.pe.daa2.servicios;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.idat.edu.pe.daa2.modelo.Sede;
import com.idat.edu.pe.daa2.repositorios.SedeRepositorio;

@Service
@Transactional

public class SedeServicios {

	@Autowired
	public SedeRepositorio sedeRepositorio;
	
	public SedeServicios() {
		
	}
	
	public Sede crear (Sede sede ) {
		return sedeRepositorio.save(sede);
	}
	
	public List<Sede> buscarTodo(){
		return (ArrayList<Sede>) sedeRepositorio.findAll();
	}
	
	public Sede buscarPorId(Integer id) {
		return sedeRepositorio.findById(id).get();
	}
	
	public Sede actualizar(Sede sedeActualizar) {
		

		Sede sedeActual = sedeRepositorio.findById(sedeActualizar.getIdSede()).get();
		
		sedeActual.setIdSede(sedeActualizar.getIdSede());
		sedeActual.setNombreSede(sedeActualizar.getNombreSede());
		sedeActual.setDireccionSede(sedeActualizar.getDireccionSede());
		
		Sede sedeActualizado = sedeRepositorio.save(sedeActual);
		return sedeActualizado;
	}
	
	
	public void eliminarSede(Integer id) {
		sedeRepositorio.deleteById(id);
	}
	
	
	
public void actualizar(int id,Sede sede) {
		
		
		Sede sedeActual =sedeRepositorio.findById(id).get();
		
		sedeActual.setNombreSede(sede.getNombreSede());
		sedeActual.setDireccionSede(sede.getDireccionSede());
		
		sedeRepositorio.save(sedeActual);
		
	}


}
