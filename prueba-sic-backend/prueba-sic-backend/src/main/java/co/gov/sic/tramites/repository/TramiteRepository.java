package co.gov.sic.tramites.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import co.gov.sic.tramites.model.Tramite;

public interface TramiteRepository extends JpaRepository<Tramite, Long> {
	@Query("SELECT t FROM Tramite t WHERE t.numeroTramite=:numeroTramite")
	public Optional<Tramite> findByNumeroTramite(String numeroTramite);
}
