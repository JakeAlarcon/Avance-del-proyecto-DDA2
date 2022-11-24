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

import com.idat.edu.pe.daa2.modelo.Docente;
import com.idat.edu.pe.daa2.servicios.DocenteServicios;

@RestController
@RequestMapping("/rest/docente")

public class DocenteRestController {





@Autowired
	private DocenteServicios  servicio;
	
	@GetMapping
	public ResponseEntity<Object> buscarTodo(){
		List<Docente> listaDocente= servicio.buscarTodo();
		
		System.out.println("LISTA DE DOCENTES : " + listaDocente);
		
		return new ResponseEntity<>(listaDocente, HttpStatus.OK);
	}
	
	@GetMapping(value="/{id}", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	
	public ResponseEntity<Object> buscarPorId(@PathVariable("id") int id ){
		Docente docente= servicio.buscarPorId(id);
		if(docente== null)
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Docente no encontrado, id proporcionado no es correcto");
		
			return new ResponseEntity<Object>(docente,HttpStatus.OK);
	}
	
	@PostMapping( produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	
	public ResponseEntity<Object> crear(@RequestBody Docente docente){
		servicio.crear(docente);
		return new ResponseEntity<Object> ("Docente creado correctamente",HttpStatus.OK);
	}
	
	@PutMapping(value="/{id}", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	
	public ResponseEntity<Object> actualizar(@PathVariable("id") int id, @RequestBody Docente docente){
		servicio.actualizar(docente);
		return new ResponseEntity<Object>("Docente  Actualizado correctamente",HttpStatus.OK);
	}
	
	@DeleteMapping(value="/{id}")
	public ResponseEntity<Object> eliminar(@PathVariable("id") int id){
		servicio.eliminarDocente(id);
		return new ResponseEntity<Object>("Docente eliminado correctamente", HttpStatus.OK);
	}


}
