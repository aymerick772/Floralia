package fr.epsi.i1cap2024produits.microservicespanier.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class RedisService {

    @Autowired
    private RedisTemplate redisTemplate;

    /**
     * Sauvegarde une valeur dans Redis avec une clé spécifiée.
     * @param key La clé sous laquelle la valeur sera stockée.
     * @param value La valeur à stocker.
     */
    public void saveValue(String key, String value) {
        redisTemplate.opsForValue().set(key, value);
    }
    public Object getValue(String key) {
        return redisTemplate.opsForValue().get(key);
    }


    /**
     * Récupère une valeur depuis Redis en utilisant une clé spécifiée.
     * @param key La clé pour laquelle récupérer la valeur.
     * @return La valeur récupérée depuis Redis, ou null si la clé n'existe pas.
     */

}