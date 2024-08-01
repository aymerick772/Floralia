package fr.epsi.i1cap2024produits.microservicespanier.Controller;

import fr.epsi.i1cap2024produits.microservicespanier.Model.Panier;
import fr.epsi.i1cap2024produits.microservicespanier.Service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/paniers")
public class RedisTestController {
    @Autowired
    private RedisService redisService;

    /**
     * Endpoint pour ajouter une fleur à un panier.
     * @param panierId L'ID du panier.
     * @param productId L'ID de la fleur.
     * @return Message de succès.
     */
    @PostMapping("/add")
    public String addProductToPanier(@RequestParam Long panierId, @RequestParam Long productId) {
        redisService.addProductToPanier(panierId, productId);
        return "Fleur ajoutée au panier avec succès!";
    }
    @GetMapping("/{id}")
    public Panier getPanierById(@PathVariable String id) {
        return redisService.getPanierById(id);
    }
}
