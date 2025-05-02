package com.maybach7.gweather.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
@Getter
@Setter
@ToString(exclude = "locations")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true, name="username")
    @NotBlank(message = "Имя пользователя обязательно")
    @Size(min=5, max=20, message = "Имя пользователя должно быть от 5 до 20 символов")
    @Pattern(regexp = "^[a-zA-Z0-9_]{5,20}$", message = "Имя пользователя может содержать только латинские буквы, цифры и \"_\"")
    private String username;

    @Column(nullable = false, name="password")
    @NotBlank(message = "Пароль обязателен")
    @Size(min = 8, message="Пароль должен быть не менее 8 символов")
    private String password;

    @Transient
    @NotBlank(message = "Повторите пароль")
    private String repeatedPassword;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Location> locations = new ArrayList<>();
}