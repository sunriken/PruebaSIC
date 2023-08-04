package co.gov.sic.tramites.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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
@Entity
public class Tramite {
	@Id
	@Column(name = "id_tramite")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long idTramite;
	@Column(name = "numero_tramite", nullable = false)
	private String numeroTramite;
	@Column(name = "anio_radicacion", nullable = false)
	private Integer anioRadicacion;
	@Column(name = "nombre_tramite", nullable = false)
	private String nombreTramite;
	@Column(name = "descripcion")
	private String descripcion;
	@ManyToOne(fetch = FetchType.EAGER) 
	@JoinColumn(name = "id_persona_radicacion", nullable = false)
	private Persona personaRadicacion;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_empleado_func_recibio", nullable = false)
	private Empleado funcionarioRecibio;
	
}
