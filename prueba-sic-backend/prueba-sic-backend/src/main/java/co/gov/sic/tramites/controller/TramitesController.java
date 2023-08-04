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

import co.gov.sic.tramites.dto.EmpleadoDto;
import co.gov.sic.tramites.dto.PersonaDto;
import co.gov.sic.tramites.dto.TramiteDto;
import co.gov.sic.tramites.service.EmpleadoService;
import co.gov.sic.tramites.service.PersonaService;
import co.gov.sic.tramites.service.TramiteService;

@Controller
@RequestMapping("/tramites")
public class TramitesController {
	private static final Logger logger = LoggerFactory.getLogger(PersonasController.class);
	
	
	@Autowired
	private TramiteService tramiteService;
	
	@GetMapping("")
	public ResponseEntity<?> obtenerTramites() {
		try {
			return new ResponseEntity<List<TramiteDto>>(tramiteService.obtenerTramites(), HttpStatus.OK);
		} catch (Exception e) {
			logger.error("Error al consultar tramites. ", e);
			return new ResponseEntity<String>("Error al consultar tramites. " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/{numeroTramite}")
	public ResponseEntity<?> consultarTramite(@PathVariable(value = "numeroTramite") String numeroTramite) {
		try {
			return new ResponseEntity<TramiteDto>(tramiteService.consultarTramite(numeroTramite), HttpStatus.OK);
		} catch (Exception e) {
			logger.error("Error al consultar el tramite ", e);
			return new ResponseEntity<String>("Error al consultar el tramite. " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	@PutMapping("")
	public ResponseEntity<?> ingresarTramite(@RequestBody TramiteDto datosTramite){
		try {
			tramiteService.ingresarTramite(datosTramite);
			return new ResponseEntity<Void>(HttpStatus.OK);
		} catch (Exception e) {
			logger.error("Error al ingresar el tramite. ", e);
			return new ResponseEntity<String>("Error al ingresar el tramite. " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
}
