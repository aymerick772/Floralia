package fr.epsi.i1cap2024produits.microservicesproduits.Service;

import fr.epsi.i1cap2024produits.microservicesproduits.Model.Fleur;
import fr.epsi.i1cap2024produits.microservicesproduits.Repository.FleurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FleurService {
    @Autowired
    private FleurRepository fleurRepository;

    public List<Fleur> getAllFleurs() {
        return fleurRepository.findAll();
    }

    public Optional<Fleur> getFleurById(Long id) {
        return fleurRepository.findById(id);
    }

    public Fleur createFleur(Fleur fleur) {
        return fleurRepository.save(fleur);
    }

    public Fleur updateFleur(Long id, Fleur fleur) {
        if (fleurRepository.existsById(id)) {
            fleur.setId(id);
            return fleurRepository.save(fleur);
        }
        return null;
    }

    public void deleteFleur(Long id) {
        fleurRepository.deleteById(id);
    }
}
