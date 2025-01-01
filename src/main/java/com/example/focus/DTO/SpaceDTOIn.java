package com.example.focus.DTO;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SpaceDTOIn {
    @NotEmpty(message = "Please enter space name")
    private String name;
    @NotEmpty(message = "Please enter space type")
    private String type;
    @NotNull(message = "Please enter space area")
    @Positive
    private Double area;
    @NotEmpty(message = "Please enter space description")
    private String description;
    @NotNull(message = "Please enter space price")
    @Positive
    private Integer price;
    private String status;
    @NotEmpty(message = "Enter image URL")
    private String image;
}
