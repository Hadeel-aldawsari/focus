package com.example.focus.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity

public class MyUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty(message = "Name cannot be empty")
    @Size(min = 2, max = 40, message = "Name must be between 2 and 40 characters")
    @Column(columnDefinition = "varchar(40) not null")
    private String name;

    @NotEmpty(message = "City cannot be empty")
    @Column(columnDefinition = "varchar(30) not null")
    private String city;

    @NotEmpty(message = "Phone number cannot be empty")
    @Pattern(regexp = "^05[0-9]{8}$", message = "Phone number must start with 05 and be followed by 8 digits")
    @Column(columnDefinition = "varchar(40) not null unique")
    private String phoneNumber;

    @NotEmpty(message = "Email cannot be empty")
    @Email(message = "Email should be valid")
    @Column(columnDefinition = "varchar(40) not null unique")
    private String email;

    @NotEmpty(message = "Username cannot be empty")
    @Size(min = 4, max = 50, message = "Username must be between 4 and 50 characters")
    @Column(columnDefinition = "varchar(40) not null unique")
    private String username;

    @NotEmpty(message = "Please enter your password")
    @Size(min = 6, message = "Password must be at least 6 characters")
    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[!@#$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>\\/?]).{6,}$",
            message = "Password must contain at least one uppercase letter, one lowercase letter, one number, and one special character")
    @Column(columnDefinition = "varchar(40) not null")
    private String password;

}
