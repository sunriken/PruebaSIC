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
import co.gov.sic.tramites.service.EmpleadoService;
import co.gov.sic.tramites.service.PersonaService;

@Controller
@RequestMapping("/empleados")
public class EmpleadosController {
	private static final Logger logger = LoggerFactory.getLogger(PersonasController.class);
	
	
	@Autowired
	private EmpleadoService empleadoService;
	
	@GetMapping("")
	public ResponseEntity<?> obtenerEmpleados() {
		try {
			return new ResponseEntity<List<EmpleadoDto>>(empleadoService.obtenerEmpleados(), HttpStatus.OK);
		} catch (Exception e) {
			logger.error("Error al consultar empleados. ", e);
			return new ResponseEntity<String>("Error al consultar empleados. " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/{tipoDocumento}-{numeroDocumento}")
	public ResponseEntity<?> consultarEmpleado(@PathVariable(value = "tipoDocumento") String tipoDocumento, @PathVariable(value = "numeroDocumento") String numeroDocumento) {
		try {
			return new ResponseEntity<EmpleadoDto>(empleadoService.consultarEmpleado(tipoDocumento, numeroDocumento), HttpStatus.OK);
		} catch (Exception e) {
			logger.error("Error al consultar el empleado ", e);
			return new ResponseEntity<String>("Error al consultar el empleado. " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	@PutMapping("")
	public ResponseEntity<?> ingresarPersona(@RequestBody EmpleadoDto datosEmpleado){
		try {
			empleadoService.ingresarEmpleado(datosEmpleado);
			return new ResponseEntity<Void>(HttpStatus.OK);
		} catch (Exception e) {
			logger.error("Error al ingresar el empleado. ", e);
			return new ResponseEntity<String>("Error al ingresar el empleado. " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
}
