package com.hotel.service.dto;

import lombok.Data;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.UUID;

@Data
public class GuestDto {
    private UUID id;
    @Size(max = 20)
    @Pattern(regexp = "^([А-Я][а-я]*|[A-Z][a-z]*)")
    private String name;
    @Size(max = 20)
    @Pattern(regexp = "^([А-Я][а-я]*|[A-Z][a-z]*)")
    private String surname;
    @Size(max = 7)
    @Pattern(regexp = "[0-9]+")
    private String tel;
    @Size(max = 2)
    @Pattern(regexp = "^[1-9][0-9]*")
    private int age;
    private String gender;
}
