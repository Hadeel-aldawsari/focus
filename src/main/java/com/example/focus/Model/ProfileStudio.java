package com.example.focus.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class ProfileStudio {
    @Id
    private Integer id;

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

    @JoinColumn(name = "studio_id")
    private Studio studio;


}