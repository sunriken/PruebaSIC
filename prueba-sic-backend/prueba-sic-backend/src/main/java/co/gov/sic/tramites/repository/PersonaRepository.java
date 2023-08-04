package co.gov.sic.tramites.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import co.gov.sic.tramites.model.Persona;

public interface PersonaRepository extends JpaRepository<Persona, Long> {
	@Query("SELECT p FROM Persona p WHERE p.tipoIdentificacion=:tipoIdentificacion AND p.numeroIdentificacion=:numeroIdentificacion")
	public Optional<Persona> findByTipoAndNumeroIdentificacion(String tipoIdentificacion, String numeroIdentificacion);
}
