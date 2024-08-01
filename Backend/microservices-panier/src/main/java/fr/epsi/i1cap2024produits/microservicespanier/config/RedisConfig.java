//package fr.epsi.i1cap2024produits.microservicespanier.config;
//
//import org.springframework.context.annotation.Configuration;
//import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
//import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;
//
//@Configuration
//@EnableRedisRepositories
//public class RedisConfig {
//    public JedisConnectionFactory connectionFactory(){
//
//    }
//}
package fr.epsi.i1cap2024produits.microservicespanier.config;

import fr.epsi.i1cap2024produits.microservicespanier.Model.Panier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RedisConfig {

    @Bean
    public LettuceConnectionFactory redisConnectionFactory() {
        // Configure Redis standalone connection
        RedisStandaloneConfiguration config = new RedisStandaloneConfiguration();
        config.setHostName("localhost");  // Remplacez par l'adresse de votre serveur Redis si nécessaire
        config.setPort(6379);             // Port par défaut pour Redis
        return new LettuceConnectionFactory(config);
    }

    @Bean
    public RedisTemplate<String, Panier> redisTemplate(RedisConnectionFactory connectionFactory) {
        RedisTemplate<String, Panier> template = new RedisTemplate<>();
        template.setConnectionFactory(connectionFactory);
        template.setKeySerializer(new StringRedisSerializer());
        template.setValueSerializer(new GenericJackson2JsonRedisSerializer());
        return template;
    }
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
