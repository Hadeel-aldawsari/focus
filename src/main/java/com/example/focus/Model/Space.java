package com.example.focus.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Space {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotEmpty(message = "Please enter space name")
    @Column(columnDefinition = "varchar(20) not null unique")
    private String name;
    @NotEmpty(message = "Please enter space type")
    @Column(columnDefinition = "varchar(20) not null ")
    private String type;
    @NotNull(message = "Please enter space area")
    @Positive
    @Column(columnDefinition = "double not null ")
    private Double area;
    @NotEmpty(message = "Please enter space description")
    @Column(columnDefinition = "varchar(60) not null")
    private String description;
    @NotNull(message = "Please enter space price")
    @Positive
    @Column(columnDefinition = "int not null ")
    private Integer price;
    private String status;
    @NotEmpty(message = "Enter image URL")
    @Column(columnDefinition = "varchar not null unique")
    private String image;


    @ManyToOne
    private Studio studio;


}
