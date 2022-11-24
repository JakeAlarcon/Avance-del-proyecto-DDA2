package com.idat.edu.pe.daa2.servicios;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.idat.edu.pe.daa2.modelo.Alumno;
import com.idat.edu.pe.daa2.repositorios.AlumnoRepositorio;

@Service
@Transactional

public class AlumnoServicios {

	@Autowired
	public AlumnoRepositorio alumnoRepositorio;
	
	public AlumnoServicios() {
		
	}
	
	public Alumno crear (Alumno alumno) {
		return alumnoRepositorio.save(alumno);
	}
	
	public List<Alumno> buscarTodo(){
		return (ArrayList<Alumno>) alumnoRepositorio.findAll();
	}
	
	public Alumno buscarPorId(Integer id) {
		return alumnoRepositorio.findById(id).get();
	}
	
	public Alumno actualizar(Alumno alumnoActualizar) {
		
		Alumno alumnoActual = alumnoRepositorio.findById(alumnoActualizar.getIdAlumno()).get();
		
		alumnoActual.setIdAlumno(alumnoActualizar.getIdAlumno());
		alumnoActual.setNombreAlumno(alumnoActualizar.getNombreAlumno());
		alumnoActual.setEdadAlumno(alumnoActualizar.getEdadAlumno());
		alumnoActual.setDireccionAlumno(alumnoActualizar.getDireccionAlumno());
		alumnoActual.setCorreoAlumno(alumnoActualizar.getCorreoAlumno());
		
		Alumno alumnoActualizado = alumnoRepositorio.save(alumnoActual);
		return alumnoActualizado;
	}
	
	
	public void eliminarAlumno(Integer id) {
		alumnoRepositorio.deleteById(id);
	}
	
	
	
	public void actualizar(int id, Alumno alumno) {
		
		
		Alumno alumnoActual =alumnoRepositorio.findById(id).get();
		
		
		alumnoActual.setNombreAlumno(alumno.getNombreAlumno());
		alumnoActual.setEdadAlumno(alumno.getEdadAlumno());
		alumnoActual.setDireccionAlumno(alumno.getDireccionAlumno());
		alumnoActual.setCorreoAlumno(alumno.getCorreoAlumno());
		
		alumnoRepositorio.save(alumnoActual);
		
	}


}
