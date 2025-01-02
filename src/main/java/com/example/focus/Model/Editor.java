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
public class Editor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty(message = "Please enter your name")
    @Column(columnDefinition = "varchar(40) not null")
    private String name;

    @NotEmpty(message = "Please enter your city")
    @Column(columnDefinition = "varchar(40) not null")
    private String city;

    @NotEmpty(message = "Please enter your phone number")
    @Pattern(regexp = "^05\\d{8}$", message = "Phone number must start with 05 and have 10 digits")
    @Column(columnDefinition = "varchar(10) not null unique")
    private String phoneNumber;

    @NotEmpty(message = "Please enter your email")
    @Email(message = "Email should be valid")
    @Column(columnDefinition = "varchar(40) not null unique")
    private String email;

    @NotEmpty(message = "Username is required")
    @Size(min = 3, max = 50, message = "Username must be between 3 and 50 characters")
    @Column(columnDefinition = "varchar(40) not null unique")
    private String username;

    @NotEmpty(message = "Please enter your password")
    @Size(min = 6, message = "Password must be at least 6 characters")
    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[!@#$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>\\/?]).{6,}$",
            message = "Password must contain at least one uppercase letter, one lowercase letter, one number, and one special character")
    @Column(columnDefinition = "varchar(40) not null")
    private String password;

    @Pattern(regexp = "(ADMIN|PHOTOGRAPHER|EDITOR)",message = "Role must be in admin or user only")
    @Column(columnDefinition = "varchar(10) not null check (role='ADMIN' or role='USER')")
    private String role;

}