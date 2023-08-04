package co.gov.sic.tramites.service;

import java.util.List;
import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.gov.sic.tramites.dto.EmpleadoDto;
import co.gov.sic.tramites.dto.PersonaDto;
import co.gov.sic.tramites.dto.TramiteDto;
import co.gov.sic.tramites.model.Empleado;
import co.gov.sic.tramites.model.Persona;
import co.gov.sic.tramites.model.Tramite;
import co.gov.sic.tramites.repository.EmpleadoRepository;
import co.gov.sic.tramites.repository.PersonaRepository;
import co.gov.sic.tramites.repository.TramiteRepository;
import co.gov.sic.tramites.util.Mapper;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class TramiteService {
	@Autowired
	private EmpleadoRepository empleadoRepository;
	
	@Autowired
	private PersonaRepository personaRepository;
	
	@Autowired
	private TramiteRepository tramiteRepository;
	
	private void ingresarTramite(TramiteDto infoTramite) throws Exception {
		Optional<Tramite> tramiteOpt = tramiteRepository.findByNumeroTramite(infoTramite.getNumeroTramite());
		if(tramiteOpt.isPresent()) {
			throw new Exception("El tramite ya existe");
		}
		else {
			Optional<Empleado> funcionarioRecibioOpt = empleadoRepository.findByTipoAndNumeroIdentificacion(infoTramite.getFuncionarioRecibio().getPersona().getTipoIdentificacion(), infoTramite.getFuncionarioRecibio().getPersona().getNumeroIdentificacion());
			if(funcionarioRecibioOpt.isEmpty()) {
				throw new Exception("El funcionario no existe");
			}
			
			Optional<Persona> personaRadicacionOpt = personaRepository
				.findByTipoAndNumeroIdentificacion(infoTramite.getPersonaRadicacion().getTipoIdentificacion(), infoTramite.getPersonaRadicacion().getNumeroIdentificacion());
			if(personaRadicacionOpt.isEmpty()){ //Si la persona ya existe, se obtiene
				throw new Exception("La persona que radica no existe");
			} 
			
			//Guardado del tramite
			Tramite tramite = Mapper.getInstance().mapTramiteDtoToTramite(infoTramite, personaRadicacionOpt.get(), funcionarioRecibioOpt.get());
			tramite.setIdTramite(null);			
			tramiteRepository.save(tramite);
		}
	}
	
	private TramiteDto consultarTramite(String numeroTramite) throws Exception {
		Optional<Tramite> tramiteOpt = tramiteRepository.findByNumeroTramite(numeroTramite);
		if(tramiteOpt.isEmpty()) throw new Exception ("El trámite no existe");
		Tramite tramite = tramiteOpt.get();
		TramiteDto tramiteDto = Mapper.getInstance().mapTramiteToTramiteDto(tramite);
		return tramiteDto;
	}
	
	private List<TramiteDto> obtenerTramites() throws Exception {
		List<TramiteDto> tramitesDto = new ArrayList<>();
		tramiteRepository.findAll().forEach(tramite -> {
			tramitesDto.add(Mapper.getInstance().mapTramiteToTramiteDto(tramite));
		});
		return tramitesDto;
	}
	
}
