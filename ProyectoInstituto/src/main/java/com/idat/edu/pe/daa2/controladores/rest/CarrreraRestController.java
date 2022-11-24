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

import com.idat.edu.pe.daa2.modelo.Carrera;
import com.idat.edu.pe.daa2.servicios.CarreraServicios;

@RestController
@RequestMapping("/rest/carrera")

public class CarrreraRestController {

	@Autowired
	private CarreraServicios  servicio;
	
	@GetMapping
	public ResponseEntity<Object> buscarTodo(){
		List<Carrera> listaCarrera = servicio.buscarTodo();
		
		System.out.println("LISTA DE CARRERAS : " + listaCarrera);
		
		return new ResponseEntity<>(listaCarrera, HttpStatus.OK);
	}
	
	@GetMapping(value="/{id}", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	
	public ResponseEntity<Object> buscarPorId(@PathVariable("id") int id ){
		Carrera carrera = servicio.buscarPorId(id);
		if(carrera== null)
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Carrera no encontrada, id proporcionado no es correcto");
		
			return new ResponseEntity<Object>(carrera,HttpStatus.OK);
	}
	
	@PostMapping( produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	
	public ResponseEntity<Object> crear(@RequestBody Carrera carrera){
		servicio.crear(carrera);
		return new ResponseEntity<Object> ("Carrera creada correctamente",HttpStatus.OK);
	}
	
	@PutMapping(value="/{id}", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	
	public ResponseEntity<Object> actualizar(@PathVariable("id") int id, @RequestBody Carrera carrera){
		servicio.actualizar(carrera);
		return new ResponseEntity<Object>("Carrera  Actualizado correctamente",HttpStatus.OK);
	}
	
	@DeleteMapping(value="/{id}")
	public ResponseEntity<Object> eliminar(@PathVariable("id") int id){
		servicio.eliminarCarrera(id);
		return new ResponseEntity<Object>("Carrera eliminado correctamente", HttpStatus.OK);
	}

}
