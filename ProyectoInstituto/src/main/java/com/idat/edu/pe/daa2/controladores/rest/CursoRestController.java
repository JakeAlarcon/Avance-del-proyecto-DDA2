package com.idat.edu.pe.daa2.controladores.rest;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.idat.edu.pe.daa2.modelo.Curso;
import com.idat.edu.pe.daa2.servicios.CursoServicios;


@RestController
@RequestMapping("/rest/curso")

public class CursoRestController {



    @Autowired
	private CursoServicios  servicio;
	
	@GetMapping
	public ResponseEntity<Object> buscarTodo(){
		List<Curso> listaCurso = servicio.buscarTodo();
		
		System.out.println("LISTA DE CURSOS : " + listaCurso);
		
		return new ResponseEntity<>(listaCurso, HttpStatus.OK);
	}
	
	@GetMapping(value="/{id}", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	
	public ResponseEntity<Object> buscarPorId(@PathVariable("id") int id ){
		Curso curso= servicio.buscarPorId(id);
		if(curso== null)
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Curso no encontrado, id proporcionado no es correcto");
		
			return new ResponseEntity<Object>(curso,HttpStatus.OK);
	}
	
	@PostMapping( produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	
	public ResponseEntity<Object> crear(@RequestBody Curso curso){
		servicio.crear(curso);
		return new ResponseEntity<Object> ("Curso creado correctamente",HttpStatus.OK);
	}
	
	@PutMapping(value="/{id}", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	
	public ResponseEntity<Object> actualizar(@PathVariable("id") int id, @RequestBody Curso curso){
		servicio.actualizar(curso);
		return new ResponseEntity<Object>("Curso  Actualizado correctamente",HttpStatus.OK);
	}
	
	@DeleteMapping(value="/{id}")
	public ResponseEntity<Object> eliminar(@PathVariable("id") int id){
		servicio.eliminarCurso(id);
		return new ResponseEntity<Object>("Curso eliminado correctamente", HttpStatus.OK);
	}

}
