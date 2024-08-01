package fr.epsi.i1cap2024produits.microservicesproduits.Controller;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import fr.epsi.i1cap2024produits.microservicesproduits.Model.Fleur;
import fr.epsi.i1cap2024produits.microservicesproduits.Service.FleurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.Map;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/fleurs")
public class FleurController {

    private final ObjectMapper objectMapper;

    @Autowired
    public FleurController(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }
    @Autowired
    private FleurService fleurService;

    @GetMapping


    public ResponseEntity<List<Fleur>> getAllFleurs() {
        List<Fleur> fleurs = fleurService.getAllFleurs();
        return ResponseEntity.ok(fleurs);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Fleur> getFleurById(@PathVariable("id") Long id) {
        Optional<Fleur> fleur = fleurService.getFleurById(id);
        return fleur.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Fleur> createFleur(@RequestBody Fleur fleur) {
        Fleur createdFleur = fleurService.createFleur(fleur);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdFleur);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Fleur> updateFleur(@PathVariable("id") Long id, @RequestBody Fleur fleur) {
        Fleur updatedFleur = fleurService.updateFleur(id, fleur);
        return updatedFleur != null ? ResponseEntity.ok(updatedFleur)
                : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFleur(@PathVariable("id") Long id) {
        fleurService.deleteFleur(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/fleurss")
    public String getFleurs(@RequestParam("callback") String callback) {
        List<Fleur> fleurs = fleurService.getAllFleurs();
        System.out.println("JEPASSISIS");
        // Exemple de données JSON
        Map<String, Object> fleursData = Collections.singletonMap("fleurs",fleurs);



        String jsonData;
        try {
            jsonData = objectMapper.writeValueAsString(fleursData);
        } catch (JsonProcessingException e) {
            // En cas d'erreur lors de la conversion en JSON
            jsonData = "{}";
        }

        // Envelopper la réponse JSON dans le callback
        return callback + "(" + jsonData + ")";

    }
}