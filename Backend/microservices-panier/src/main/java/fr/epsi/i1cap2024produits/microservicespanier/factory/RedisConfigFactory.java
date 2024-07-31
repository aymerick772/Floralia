package fr.epsi.i1cap2024produits.microservicespanier.factory;

import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericToStringSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;


public class RedisConfigFactory {
    @Bean
    public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory redisConnectionFactory) {
        RedisTemplate<String, Object> template = new RedisTemplate<>();
        template.setConnectionFactory(redisConnectionFactory);

        // Sérialiseur pour les clés
        template.setKeySerializer(new StringRedisSerializer());

        // Sérialiseur pour les valeurs
        template.setValueSerializer(new GenericToStringSerializer<>(Object.class));

        // Sérialiseur pour les valeurs dans les hachages
        template.setHashKeySerializer(new StringRedisSerializer());
        template.setHashValueSerializer(new GenericToStringSerializer<>(Object.class));

        return template;
    }

}
