package fr.epsi.i1cap2024produits.microservicespanier.Repository;

import fr.epsi.i1cap2024produits.microservicespanier.Model.Panier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface PanierRepositoy extends JpaRepository<Panier, Long> {
}
