package com.moskalev.session.dto.redis;


import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.index.Indexed;

/*класс для редис репозитория*/
@Data
@RedisHash("employee")
public class Person {
    @Id
    private String id;
    private String name;
    @Indexed
    private String lastname;
    private int age;


    private Address address;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Person(String name, String lastname) {
        this.name = name;
        this.lastname = lastname;
    }

    public Person(String name, String lastname, Address address) {
        this.name = name;
        this.lastname = lastname;
        this.address = address;
    }
}
