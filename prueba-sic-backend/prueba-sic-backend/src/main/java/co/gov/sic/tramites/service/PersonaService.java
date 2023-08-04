package co.gov.sic.tramites.service;

import java.util.List;
import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.gov.sic.tramites.dto.PersonaDto;
import co.gov.sic.tramites.model.Persona;
import co.gov.sic.tramites.repository.PersonaRepository;
import co.gov.sic.tramites.util.Mapper;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class PersonaService {
	@Autowired
	private PersonaRepository personaRepository;
	
	private void ingresarPersona(PersonaDto infoPersona) throws Exception {
		if(personaRepository
				.findByTipoAndNumeroIdentificacion(infoPersona.getTipoIdentificacion(), infoPersona.getNumeroIdentificacion()).isPresent()){
			throw new Exception("La persona ya existe.");
		} else {
			Persona persona = Mapper.getInstance().mapPersonaDtoToPersona(infoPersona);
			persona.setIdPersona(null);
			personaRepository.save(persona);
		}
	}
	
	private PersonaDto consultarPersona(String tipoIdentificacion, String numeroIdentificacion) throws Exception {
		Optional<Persona> personaOpt = personaRepository.findByTipoAndNumeroIdentificacion(tipoIdentificacion, numeroIdentificacion);
		if(personaOpt.isEmpty()) throw new Exception ("La persona no existe");
		Persona persona = personaOpt.get();
		PersonaDto personaDto = Mapper.getInstance().mapPersonaToPersonaDto(persona);
		return personaDto;
	}
	
	private List<PersonaDto> obtenerPersonas() throws Exception {
		List<PersonaDto> personasDto = new ArrayList<>();
		personaRepository.findAll().forEach(persona -> {
			personasDto.add(Mapper.getInstance().mapPersonaToPersonaDto(persona));
		});
		return personasDto;
	}
	
}
