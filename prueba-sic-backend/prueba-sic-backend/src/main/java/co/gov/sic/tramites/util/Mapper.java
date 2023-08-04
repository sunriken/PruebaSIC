package co.gov.sic.tramites.util;

import co.gov.sic.tramites.dto.EmpleadoDto;
import co.gov.sic.tramites.dto.PersonaDto;
import co.gov.sic.tramites.dto.TramiteDto;
import co.gov.sic.tramites.model.Empleado;
import co.gov.sic.tramites.model.Persona;
import co.gov.sic.tramites.model.Tramite;

public class Mapper {
	private static Mapper instance;
	
	private Mapper() {
	}
	
	public static Mapper getInstance() {
		if(instance==null) instance = new Mapper();
		return instance;
	}
	
	public PersonaDto mapPersonaToPersonaDto(Persona persona) {
		return PersonaDto.builder()
				.idPersona(persona.getIdPersona())
				.tipoIdentificacion(persona.getTipoIdentificacion())
				.numeroIdentificacion(persona.getNumeroIdentificacion())
				.nombres(persona.getNombres())
				.apellidos(persona.getApellidos())
				.telefono(persona.getTelefono())
				.direccion(persona.getDireccion())
				.email(persona.getEmail())
				.build();
	}
	
	public Persona mapPersonaDtoToPersona(PersonaDto infoPersona) {
		return Persona.builder()
			.idPersona(infoPersona.getIdPersona())
			.tipoIdentificacion(infoPersona.getTipoIdentificacion())
			.numeroIdentificacion(infoPersona.getNumeroIdentificacion())
			.nombres(infoPersona.getNombres())
			.apellidos(infoPersona.getApellidos())
			.telefono(infoPersona.getTelefono())
			.direccion(infoPersona.getDireccion())
			.email(infoPersona.getEmail())
			.build();
	}
	
	public EmpleadoDto mapEmpleadoToEmpleadoDto(Empleado empleado) {	
		return EmpleadoDto.builder()
				.idEmpleado(empleado.getIdEmpleado())
				.persona(this.mapPersonaToPersonaDto(empleado.getPersona()))
				.dependencia(empleado.getDependencia())
				.fechaIngreso(empleado.getFechaIngreso())
				.build();
	}
	
	public Empleado mapEmpleadoDtoToEmpleado(EmpleadoDto infoEmpleado, Persona persona) {
		return Empleado.builder()
		.persona(persona)
		.dependencia(infoEmpleado.getDependencia())
		.fechaIngreso(infoEmpleado.getFechaIngreso())
		.build();
	}

	public TramiteDto mapTramiteToTramiteDto(Tramite tramite) {
		return TramiteDto.builder()
				.idTramite(tramite.getIdTramite())
				.numeroTramite(tramite.getNumeroTramite())
				.anioRadicacion(tramite.getAnioRadicacion())
				.nombreTramite(tramite.getNombreTramite())
				.descripcion(tramite.getDescripcion())
				.personaRadicacion(this.mapPersonaToPersonaDto(tramite.getPersonaRadicacion()))
				.funcionarioRecibio(this.mapEmpleadoToEmpleadoDto(tramite.getFuncionarioRecibio()))
				.build();
	}
	
	public Tramite mapTramiteDtoToTramite(TramiteDto infoTramite, Persona personaRadicacion, Empleado funcionarioRecibio) {
		return Tramite.builder()
				.idTramite(infoTramite.getIdTramite())
				.numeroTramite(infoTramite.getNumeroTramite())
				.anioRadicacion(infoTramite.getAnioRadicacion())
				.nombreTramite(infoTramite.getNombreTramite())
				.descripcion(infoTramite.getDescripcion())
				.personaRadicacion(personaRadicacion)
				.funcionarioRecibio(funcionarioRecibio)
				.build();
	}
	
}
