package co.gov.sic.tramites.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Persona {
	@Id
	@Column(name = "id_persona")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long idPersona;
	@Column(name="tipo_identificacion", nullable = false)
	private String tipoIdentificacion;
	@Column(name="numero_identificacion", nullable = false)
	private String numeroIdentificacion;
	@Column(name="nombres", nullable = false)
	private String nombres;
	@Column(name="apellidos", nullable = false)
	private String apellidos;
	@Column(name="telefono", nullable = false)
	private String telefono;
	@Column(name="direccion", nullable = false)
	private String direccion;
	@Column(name="email", nullable = false)
	private String email;
}
