package com.moskalev.session.utils;

import com.moskalev.session.dto.redis.Address;
import com.moskalev.session.dto.redis.Person;
import com.moskalev.session.dto.redis.SimplePerson;
import com.moskalev.session.repository.redis.PersonRepository;
import com.moskalev.session.repository.redis.SimplePersonRepository;
import org.springframework.context.ApplicationContext;

public class RedisUtils {
//    @Bean
//    public RedisOperations redisOperations(LettuceConnectionFactory connectionFactory) {
//        RedisTemplate<String, String> redisTemplate = new RedisTemplate<>();
//        redisTemplate.setConnectionFactory(connectionFactory);
//        redisTemplate.setEnableTransactionSupport(true);
//        return redisTemplate;
//    }

    public static void saveTestDataForRedis(ApplicationContext context) {
        // useDefaultRedisRepo(context);
      //  useCustomRedisRepo(context);

    }

    private static void useCustomRedisRepo(ApplicationContext context) {
        SimplePersonRepository repository = context.getBean(SimplePersonRepository.class);
        String id = repository.save(new SimplePerson("Cidre"));
        SimplePerson person = repository.findById(id);
        System.out.println(person.getName());
    }

    private static void useDefaultRedisRepo(ApplicationContext context) {
        savePerson(context);
        saveAddress(context);
    }

    private static void savePerson(ApplicationContext context) {
        PersonRepository repository = context.getBean(PersonRepository.class);
        repository.save(new Person("Ivan", "Ivanov"));
        repository.save(new Person("Cidre", "Sidorov"));
    }

    private static void saveAddress(ApplicationContext context) {
        PersonRepository repository = context.getBean(PersonRepository.class);
        Address omsk = new Address("Omsk", "Lenina", "2");
        repository.save(new Person("Cidre", "Sidorov", omsk));
    }
}
