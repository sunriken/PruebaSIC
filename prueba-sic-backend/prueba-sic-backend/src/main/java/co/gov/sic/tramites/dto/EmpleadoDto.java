package co.gov.sic.tramites.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EmpleadoDto {
	private Long idEmpleado;
	private PersonaDto persona;
	private String dependencia;
	private LocalDateTime fechaIngreso;	
}
