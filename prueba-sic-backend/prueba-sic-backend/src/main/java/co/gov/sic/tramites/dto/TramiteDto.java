package co.gov.sic.tramites.dto;

import co.gov.sic.tramites.model.Empleado;
import co.gov.sic.tramites.model.Persona;
import jakarta.persistence.Column;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TramiteDto {
	private Long idTramite;
	private String numeroTramite;
	private Integer anioRadicacion;
	private String nombreTramite;
	private String descripcion;
	private PersonaDto personaRadicacion;
	private EmpleadoDto funcionarioRecibio;
}
