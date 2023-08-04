package co.gov.sic.tramites.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import co.gov.sic.tramites.dto.PersonaDto;
import co.gov.sic.tramites.service.PersonaService;

@Controller
@RequestMapping("/personas")
public class PersonasController {
	private static final Logger logger = LoggerFactory.getLogger(PersonasController.class);
	
	
	@Autowired
	private PersonaService personaService;
	
	@GetMapping("")
	public ResponseEntity<?> obtenerPersonas() {
		try {
			return new ResponseEntity<List<PersonaDto>>(personaService.obtenerPersonas(), HttpStatus.OK);
		} catch (Exception e) {
			logger.error("Error al consultar personas. ", e);
			return new ResponseEntity<String>("Error al consultar personas. " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/{tipoDocumento}-{numeroDocumento}")
	public ResponseEntity<?> consultarPersona(@PathVariable(value = "tipoDocumento") String tipoDocumento, @PathVariable(value = "numeroDocumento") String numeroDocumento) {
		try {
			return new ResponseEntity<PersonaDto>(personaService.consultarPersona(tipoDocumento, numeroDocumento), HttpStatus.OK);
		} catch (Exception e) {
			logger.error("Error al consultar la persona. ", e);
			return new ResponseEntity<String>("Error al consultar la persona. " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	@PutMapping("")
	public ResponseEntity<?> ingresarPersona(@RequestBody PersonaDto datosPersona){
		try {
			personaService.ingresarPersona(datosPersona);
			return new ResponseEntity<Void>(HttpStatus.OK);
		} catch (Exception e) {
			logger.error("Error al consultar la persona. ", e);
			return new ResponseEntity<String>("Error al ingresar la persona. " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
}
