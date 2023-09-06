package com.moskalev.session.dto.redis;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Address {
    private String city;
    private String street;
    private String number;
}
