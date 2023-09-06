package com.moskalev.session.repository.redis;

import com.moskalev.session.dto.redis.SimplePerson;
import org.springframework.data.redis.core.RedisOperations;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**Кастомный репозиторий для redis*/
@Repository
@Transactional
public class SimplePersonRepository {

    private final RedisOperations<String, String> ops;

    public SimplePersonRepository(RedisOperations<String, String> opss) {
        this.ops = opss;
    }

    public SimplePerson findById(String id) {
        String name = ops.opsForValue().get(id);
        return new SimplePerson(id, name);
    }

    public String save(SimplePerson person) {
        ops.opsForValue().set(person.getId(), person.getName());
        return person.getId();
    }
}