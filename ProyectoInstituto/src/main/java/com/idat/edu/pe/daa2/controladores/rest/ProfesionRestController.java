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

import com.idat.edu.pe.daa2.modelo.Profesion;
import com.idat.edu.pe.daa2.servicios.ProfesionServicios;

@RestController
@RequestMapping("/rest/profesion")

public class ProfesionRestController {

	@Autowired
	private ProfesionServicios  servicio;
	
	@GetMapping
	public ResponseEntity<Object> buscarTodo(){
		List<Profesion> listaProfesion= servicio.buscarTodo();
		
		System.out.println("LISTA DE PROFESIONES : " + listaProfesion);
		
		return new ResponseEntity<>(listaProfesion, HttpStatus.OK);
	}
	
	@GetMapping(value="/{id}", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	
	public ResponseEntity<Object> buscarPorId(@PathVariable("id") int id ){
		Profesion profesion= servicio.buscarPorId(id);
		if(profesion== null)
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Profesion no encontrado, id proporcionado no es correcto");
		
			return new ResponseEntity<Object>(profesion,HttpStatus.OK);
	}
	
	@PostMapping( produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	
	public ResponseEntity<Object> crear(@RequestBody Profesion profesion){
		servicio.crear(profesion);
		return new ResponseEntity<Object> ("Profesion creado correctamente",HttpStatus.OK);
	}
	
	@PutMapping(value="/{id}", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	
	public ResponseEntity<Object> actualizar(@PathVariable("id") int id, @RequestBody Profesion profesion){
		servicio.actualizar(profesion);
		return new ResponseEntity<Object>("Profesion Actualizado correctamente",HttpStatus.OK);
	}
	
	@DeleteMapping(value="/{id}")
	public ResponseEntity<Object> eliminar(@PathVariable("id") int id){
		servicio.eliminarProfesion(id);
		return new ResponseEntity<Object>("Profesion eliminado correctamente", HttpStatus.OK);
	}


}
