package com.example.auth.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity(name ="user")
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idUser;

    @NotNull(message = "First name cannot be null")
    @NotEmpty(message = "First name cannot be empty")
    private String firstNameUser;

    @NotNull(message = "Last name cannot be null")
    @NotEmpty(message = "Last name cannot be empty")
    private String lastNameUser;

    @NotNull(message = "Email cannot be null")
    @NotEmpty(message = "Email cannot be empty")
    private String emailUser;

    @NotNull(message = "Username cannot be null")
    @NotEmpty(message = "Username cannot be empty")
    private String usernameUser;

    @NotNull(message = "Password cannot be null")
    @NotEmpty(message = "Password cannot be empty")
    private String passwordUser;


    @NotNull(message = "Address cannot be null")
    @NotEmpty(message = "Address name cannot be empty")
    private String addressUser;


    public User() {
    }

    public User(int idUser, String firstNameUser, String lastNameUser, String emailUser, String usernameUser, String passwordUser, String addressUser) {
        this.idUser = idUser;
        this.firstNameUser = firstNameUser;
        this.lastNameUser = lastNameUser;
        this.emailUser = emailUser;
        this.usernameUser = usernameUser;
        this.passwordUser = passwordUser;
        this.addressUser = addressUser;
    }
}
