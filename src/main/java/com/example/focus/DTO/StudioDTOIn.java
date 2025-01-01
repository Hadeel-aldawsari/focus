package com.example.focus.DTO;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudioDTOIn {
    @NotEmpty(message = "Please enter username")
    private String username;
    @NotEmpty(message = "Please enter password")
    private String password;
    @NotEmpty(message = "Please enter studio name")
    private String name;
    @NotEmpty(message = "Please enter description")
    private String description;
    @NotEmpty(message = "Please enter studio location")
    private String location;
    @NotEmpty(message = "Please enter studio commercial Record")
    @Pattern(regexp = "10\\d{9}",message = "Enter commercial Record start with 10 and just 9 digits")
    private String commercialRecord;
}
