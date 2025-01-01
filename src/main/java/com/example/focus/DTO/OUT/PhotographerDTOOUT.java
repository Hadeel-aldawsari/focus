package com.example.focus.DTO.OUT;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PhotographerDTOOUT {
    private String username;
    private String name;

    private String city;

    private String email;
    private String phoneNumber;



}
