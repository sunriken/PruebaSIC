package co.gov.sic.tramites.model;

import java.time.LocalDateTime;

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
public class Empleado {
	@Id
	@Column(name="id_empleado")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long idEmpleado;
	@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_persona", nullable = false)
	private Persona persona;
	@Column(name="dependencia", nullable = false)
	private String dependencia;
	@Column(name="fecha_ingreso", nullable = false)
	private LocalDateTime fechaIngreso;	
}
