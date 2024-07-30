package fr.epsi.i1cap2024produits.microservicesachats.Repository;

import fr.epsi.i1cap2024produits.microservicesachats.Model.Historique;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface HistoroqueRepository  extends JpaRepository<Historique, Long> {
}
