package com.example.focus.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
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
    @NotEmpty(message = "Please enter password")
    @Column(columnDefinition = "varchar(30) not null")
    private String password;
    @NotEmpty(message = "Please enter studio name")
    @Column(columnDefinition = "varchar(30) not null unique")
    private String name;
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
    private Boolean isActivated;



    @OneToMany
    private Set<Space> spaces;

}
