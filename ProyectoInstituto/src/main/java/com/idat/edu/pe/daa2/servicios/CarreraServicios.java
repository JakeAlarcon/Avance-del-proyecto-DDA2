package com.idat.edu.pe.daa2.servicios;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.idat.edu.pe.daa2.modelo.Carrera;
import com.idat.edu.pe.daa2.repositorios.CarreraRepositorio;

@Service
@Transactional

public class CarreraServicios {

	@Autowired 
	public CarreraRepositorio carreraRepositorio;
	
	public CarreraServicios() {
		
	}
	
	public Carrera crear (Carrera carrera) {
		return carreraRepositorio.save(carrera);
	}
	
	public List<Carrera> buscarTodo(){
		return (ArrayList<Carrera>) carreraRepositorio.findAll();
	}
	
	public Carrera buscarPorId(Integer id) {
		return carreraRepositorio.findById(id).get();
	}
	
	public Carrera actualizar(Carrera carreraActualizar) {
		

		Carrera carreraActual = carreraRepositorio.findById(carreraActualizar.getIdCarrera()).get();
		
		carreraActual.setIdCarrera(carreraActualizar.getIdCarrera());
		carreraActual.setNombreCarrera(carreraActualizar.getNombreCarrera());
		carreraActual.setTotalCreditos(carreraActualizar.getTotalCreditos());
		
		Carrera carreraActualizado = carreraRepositorio.save(carreraActual);
		return carreraActualizado;
	}
	
	
	public void eliminarCarrera(Integer id) {
		carreraRepositorio.deleteById(id);
	}
	
	
	
public void actualizar(int id,Carrera carrera) {
		
		
		Carrera carreraActual =carreraRepositorio.findById(id).get();
		
		
		carreraActual.setNombreCarrera(carrera.getNombreCarrera());
		carreraActual.setTotalCreditos(carrera.getTotalCreditos());
		carreraActual.setSede(carrera.getSede());
		
		carreraRepositorio.save(carreraActual);
		
	}
}
