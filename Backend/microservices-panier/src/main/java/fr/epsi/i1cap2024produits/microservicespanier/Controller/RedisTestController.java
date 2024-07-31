package fr.epsi.i1cap2024produits.microservicespanier.Controller;

import fr.epsi.i1cap2024produits.microservicespanier.Service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.stream.Collectors;

@RestController
public class RedisTestController {
    @Autowired
    private RedisService redisService;

    @PostMapping("/test/save")
    public String save(@RequestParam String key, @RequestParam String value) {
        redisService.saveValue(key, value);
        return "Value saved successfully!";
    }

    @GetMapping("/test/get")
    public String get(@RequestParam String key) {
        Object value = redisService.getValue(key);
        return value != null ? "Value retrieved: " + value : "Value not found.";
    }


    @Autowired
    private StringRedisTemplate redisTemplate;

    @GetMapping("/ping")
    public String ping() {
        try {
            redisTemplate.getConnectionFactory().getConnection().ping();
            return "Redis is reachable!";
        } catch (Exception e) {
            return "Redis is not reachable: " + e.getMessage();
        }
    }
}
