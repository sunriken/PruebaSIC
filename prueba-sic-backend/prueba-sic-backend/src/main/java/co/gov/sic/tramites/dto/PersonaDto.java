package co.gov.sic.tramites.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PersonaDto {
	private Long idPersona;
	private String tipoIdentificacion;
	private String numeroIdentificacion;
	private String nombres;
	private String apellidos;
	private String telefono;
	private String direccion;
	private String email;
}
