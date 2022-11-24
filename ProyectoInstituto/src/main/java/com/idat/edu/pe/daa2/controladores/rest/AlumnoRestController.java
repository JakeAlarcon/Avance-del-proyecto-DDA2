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

import com.idat.edu.pe.daa2.modelo.Alumno;
import com.idat.edu.pe.daa2.servicios.AlumnoServicios;

@RestController
@RequestMapping("/rest/alumno")

public class AlumnoRestController {

	@Autowired
	private AlumnoServicios  servicio;
	
	@GetMapping
	public ResponseEntity<Object> buscarTodo(){
		List<Alumno> listaAlumno = servicio.buscarTodo();
		
		System.out.println("LISTA DE ALUMNOS : " + listaAlumno);
		
		return new ResponseEntity<>(listaAlumno, HttpStatus.OK);
	}
	
	@GetMapping(value="/{id}", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	
	public ResponseEntity<Object> buscarPorId(@PathVariable("id") int id ){
		Alumno alumno = servicio.buscarPorId(id);
		if(alumno== null)
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Alumno no encontrada, id proporcionado no es correcto");
		
			return new ResponseEntity<Object>(alumno,HttpStatus.OK);
	}
	
	@PostMapping( produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	
	public ResponseEntity<Object> crear(@RequestBody Alumno alumno){
		servicio.crear(alumno);
		return new ResponseEntity<Object> ("Alumno creada correctamente",HttpStatus.OK);
	}
	
	@PutMapping(value="/{id}", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	
	public ResponseEntity<Object> actualizar(@PathVariable("id") int id, @RequestBody Alumno alumno){
		servicio.actualizar(alumno);
		return new ResponseEntity<Object>("Alumno Actualizado correctamente",HttpStatus.OK);
	}
	
	@DeleteMapping(value="/{id}")
	public ResponseEntity<Object> eliminar(@PathVariable("id") int id){
		servicio.eliminarAlumno(id);
		return new ResponseEntity<Object>("Alumno eliminado correctamente", HttpStatus.OK);
	}

}
