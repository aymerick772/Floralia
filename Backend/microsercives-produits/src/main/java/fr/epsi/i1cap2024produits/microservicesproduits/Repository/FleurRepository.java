package fr.epsi.i1cap2024produits.microservicesproduits.Repository;

import fr.epsi.i1cap2024produits.microservicesproduits.Model.Fleur;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource
public interface FleurRepository extends JpaRepository<Fleur, Long> {

}
