package co.gov.sic.tramites.service;

import java.util.List;
import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.gov.sic.tramites.dto.EmpleadoDto;
import co.gov.sic.tramites.dto.PersonaDto;
import co.gov.sic.tramites.model.Empleado;
import co.gov.sic.tramites.model.Persona;
import co.gov.sic.tramites.repository.EmpleadoRepository;
import co.gov.sic.tramites.repository.PersonaRepository;
import co.gov.sic.tramites.util.Mapper;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class EmpleadoService {
	@Autowired
	private EmpleadoRepository empleadoRepository;
	
	@Autowired
	private PersonaRepository personaRepository;
	
	public void ingresarEmpleado(EmpleadoDto infoEmpleado) throws Exception {
		Optional<Empleado> empleadoOpt = empleadoRepository.findByTipoAndNumeroIdentificacion(infoEmpleado.getPersona().getTipoIdentificacion(), infoEmpleado.getPersona().getNumeroIdentificacion());
		if(empleadoOpt.isPresent()) {
			throw new Exception("El empleado ya existe");
		}
		else {	
			Optional<Persona> personaOpt = personaRepository
					.findByTipoAndNumeroIdentificacion(infoEmpleado.getPersona().getTipoIdentificacion(), infoEmpleado.getPersona().getNumeroIdentificacion());
			Persona persona;
			if(personaOpt.isPresent()){ //Si la persona ya existe, se obtiene
				persona = personaOpt.get();
			} else {
				PersonaDto infoPersona = infoEmpleado.getPersona();
				persona = Mapper.getInstance().mapPersonaDtoToPersona(infoPersona);
				persona.setIdPersona(null);
				persona=personaRepository.save(persona);
			}
			//Creacion del empleado
			Empleado empleado = Mapper.getInstance().mapEmpleadoDtoToEmpleado(infoEmpleado, persona);
			empleado.setIdEmpleado(null);
			empleadoRepository.save(empleado);
		}
		
	}
	
	public EmpleadoDto consultarEmpleado(String tipoIdentificacion, String numeroIdentificacion) throws Exception {
		Optional<Empleado> empleadoOpt = empleadoRepository.findByTipoAndNumeroIdentificacion(tipoIdentificacion, numeroIdentificacion);
		if(empleadoOpt.isEmpty()) throw new Exception ("El empleado no existe");
		Empleado empleado = empleadoOpt.get();
		EmpleadoDto empleadoDto = Mapper.getInstance().mapEmpleadoToEmpleadoDto(empleado);
		return empleadoDto;
	}
	
	public List<EmpleadoDto> obtenerEmpleados() throws Exception {
		List<EmpleadoDto> empleadosDto = new ArrayList<>();
		empleadoRepository.findAll().forEach(empleado -> {
			empleadosDto.add(Mapper.getInstance().mapEmpleadoToEmpleadoDto(empleado));
		});
		return empleadosDto;
	}
	
}
