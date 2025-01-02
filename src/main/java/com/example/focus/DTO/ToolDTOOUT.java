package com.example.focus.DTO;


import com.example.focus.Model.Photographer;
import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ToolDTOOUT {

    private String name;

    private String description;

    private String category;

    private String brand;

    private String condition;

    private Double rentalPrice;

    private String imageUrl;

    private Integer photographer_id;
}
