package com.moskalev.session.dto.redis;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

/**
 * Класс для реализации кастомного репозитория для редис
 */
@Getter
@Setter
public class SimplePerson {
    private String id;
    private String name;

    public SimplePerson(String name) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
    }

    public SimplePerson(String id, String name) {
        this.id = id;
        this.name = name;
    }
}
