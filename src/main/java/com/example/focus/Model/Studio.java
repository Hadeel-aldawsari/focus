package com.example.focus.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.*;
import java.util.Set;

@Setter
@Getter
@Entity
@AllArgsConstructor
@NoArgsConstructor

public class Studio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty(message = "Please enter username")
    @Column(columnDefinition = "varchar(30) not null unique")
    private String username;

    @NotEmpty(message = "Please enter your password")
    @Size(min = 6, message = "Password must be at least 6 characters")
    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[!@#$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>\\/?]).{6,}$",
            message = "Password must contain at least one uppercase letter, one lowercase letter, one number, and one special character")
    @Column(columnDefinition = "varchar(40) not null")
    private String password;

    @NotEmpty(message = "Please enter studio name")
    @Column(columnDefinition = "varchar(30) not null unique")
    private String name;

    @NotEmpty(message = "Please enter your phone number")
    @Pattern(regexp = "^05\\d{8}$", message = "Phone number must start with 05 and have 10 digits")
    @Column(columnDefinition = "varchar(10) not null unique")
    private String phoneNumber;

    @NotEmpty(message = "Please enter your email")
    @Email(message = "Email should be valid")
    @Column(columnDefinition = "varchar(40) not null unique")
    private String email;

    @NotEmpty(message = "Please enter description")
    @Column(columnDefinition = "varchar(60) not null")
    private String description;

    @NotEmpty(message = "Please enter studio location")
    @Column(columnDefinition = "varchar(20) not null")
    private String location;

    @NotEmpty(message = "Please enter studio commercial Record")
    @Pattern(regexp = "10\\d{9}",message = "Enter commercial Record start with 10 and just 9 digits")
    @Column(columnDefinition = "varchar(9) not null unique")
    private String commercialRecord;

    @Column(columnDefinition = "boolean ")
    private Boolean isActivated;


    @OneToMany
    private Set<Space> spaces;

}
