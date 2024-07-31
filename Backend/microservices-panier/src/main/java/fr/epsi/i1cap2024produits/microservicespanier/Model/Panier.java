package fr.epsi.i1cap2024produits.microservicespanier.Model;

import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;
import java.util.List;

@RedisHash("panier")
public class Panier implements Serializable {
    private Long id;
    private List<String> product;

    // Getters et setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<String> getItems() {
        return product;
    }

    public void setItems(List<String> items) {
        this.product = items;
    }
}
