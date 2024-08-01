package fr.epsi.i1cap2024produits.microservicespanier.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import fr.epsi.i1cap2024produits.microservicespanier.Model.FleurDTO;
import fr.epsi.i1cap2024produits.microservicespanier.Model.Panier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.ArrayList;

@Service
public class RedisService {

    @Autowired
    private RedisTemplate<String, Panier> redisTemplate;  // Spécifiez le type pour RedisTemplate

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private ObjectMapper objectMapper;

    private static final String KEY_PREFIX = "panier:";


    /**
     * Sauvegarde un panier dans Redis avec une clé spécifiée.
     * @param panier Le panier à stocker.
     */
    public void savePanier(Panier panier) {
        redisTemplate.opsForValue().set("panier:" + panier.getId(), panier);
    }

    /**
     * Récupère un panier depuis Redis.
     * @param panierId L'ID du panier à récupérer.
     * @return Le panier récupéré depuis Redis, ou un nouveau panier si le panier n'existe pas.
     */
    public Panier getPanier(Long panierId) {
        Panier panier = redisTemplate.opsForValue().get("panier:" + panierId);
        if (panier == null) {
            panier = new Panier();
            panier.setId(panierId);
            panier.setItems(new ArrayList<>());
        }
        return panier;
    }

    /**
     * Ajoute une fleur au panier en récupérant ses informations depuis le microservice de fleurs.
     * @param panierId L'ID du panier auquel ajouter la fleur.
     * @param productId L'ID de la fleur à ajouter.
     */
    public void addProductToPanier(Long panierId, Long productId) {
        String productServiceUrl = "http://localhost:8081/fleurs/" + productId;
        FleurDTO fleur = restTemplate.getForObject(productServiceUrl, FleurDTO.class);

        if (fleur != null) {
            String fleurJson;
            try {
                fleurJson = objectMapper.writeValueAsString(fleur);
            } catch (IOException e) {
                throw new RuntimeException("Failed to convert FleurDTO to JSON", e);
            }

            Panier panier = getPanier(panierId);
            panier.getItems().add(fleurJson);  // Ajouter la fleur au panier

            savePanier(panier);  // Sauvegarder le panier dans Redis
        }
    }
    public Panier getPanierById(String id) {
        return redisTemplate.opsForValue().get(KEY_PREFIX + id);
    }
}
