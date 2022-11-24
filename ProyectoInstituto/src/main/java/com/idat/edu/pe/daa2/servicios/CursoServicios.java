package com.idat.edu.pe.daa2.servicios;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.idat.edu.pe.daa2.modelo.Curso;
import com.idat.edu.pe.daa2.repositorios.CursoRepositorio;

@Service
@Transactional

public class CursoServicios {

	@Autowired
	public CursoRepositorio cursoRepositorio;
	
	public CursoServicios() {
		
	}
	
	public Curso crear (Curso curso) {
		return cursoRepositorio.save(curso);
	}
	
	public List<Curso> buscarTodo(){
		return (ArrayList<Curso>) cursoRepositorio.findAll();
	}
	
	public Curso buscarPorId(Integer id) {
		return cursoRepositorio.findById(id).get();
	}
	
	public Curso actualizar(Curso cursoActualizar) {
		

		Curso cursoActual = cursoRepositorio.findById(cursoActualizar.getIdCurso()).get();
		
		cursoActual.setIdCurso(cursoActualizar.getIdCurso());
		cursoActual.setNombreCurso(cursoActualizar.getNombreCurso());
		cursoActual.setCreditoCurso(cursoActualizar.getCreditoCurso());
		
		Curso cursoActualizado = cursoRepositorio.save(cursoActual);
		return cursoActualizado;
	}
	
	
	public void eliminarCurso(Integer id) {
		cursoRepositorio.deleteById(id);
	}
	
	
	
public void actualizar(int id,Curso curso) {
		
		
		Curso cursoActual =cursoRepositorio.findById(id).get();
		
		
		cursoActual.setNombreCurso(curso.getNombreCurso());
		cursoActual.setCreditoCurso(curso.getCreditoCurso());
		cursoActual.setAlumno(curso.getAlumno());
		cursoActual.setCarrera(curso.getCarrera());
		cursoActual.setDocente(curso.getDocente());
		
		cursoRepositorio.save(cursoActual);
		
	}

}
