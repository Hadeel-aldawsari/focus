package com.example.focus.DTO;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ProfileDTOOUT {

    private String description;

    private Integer numberOfPosts;

    private String image;
}