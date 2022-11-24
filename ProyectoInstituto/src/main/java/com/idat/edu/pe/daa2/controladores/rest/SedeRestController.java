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

import com.idat.edu.pe.daa2.modelo.Sede;
import com.idat.edu.pe.daa2.servicios.SedeServicios;

@RestController
@RequestMapping("/rest/sede")

public class SedeRestController {

	@Autowired
	private SedeServicios  servicio;
	
	@GetMapping
	public ResponseEntity<Object> buscarTodo(){
		List<Sede> listaSede= servicio.buscarTodo();
		
		System.out.println("LISTA DE SEDES : " + listaSede);
		
		return new ResponseEntity<>(listaSede, HttpStatus.OK);
	}
	
	@GetMapping(value="/{id}", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	
	public ResponseEntity<Object> buscarPorId(@PathVariable("id") int id ){
		Sede sede= servicio.buscarPorId(id);
		if(sede== null)
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Sede no encontrado, id proporcionado no es correcto");
		
			return new ResponseEntity<Object>(sede,HttpStatus.OK);
	}
	
	@PostMapping( produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	
	public ResponseEntity<Object> crear(@RequestBody Sede sede){
		servicio.crear(sede);
		return new ResponseEntity<Object> ("Sede creado correctamente",HttpStatus.OK);
	}
	
	@PutMapping(value="/{id}", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	
	public ResponseEntity<Object> actualizar(@PathVariable("id") int id, @RequestBody Sede sede){
		servicio.actualizar(sede);
		return new ResponseEntity<Object>("Sede Actualizado correctamente",HttpStatus.OK);
	}
	
	@DeleteMapping(value="/{id}")
	public ResponseEntity<Object> eliminar(@PathVariable("id") int id){
		servicio.eliminarSede(id);
		return new ResponseEntity<Object>("Sede eliminado correctamente", HttpStatus.OK);
	}


}
