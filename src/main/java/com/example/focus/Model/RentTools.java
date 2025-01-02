package com.example.focus.Model;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity

public class RentTools {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty(message = "Please enter start date")
    @Column(columnDefinition = "DATETIME not null")
    private LocalDate startDate;

    @NotEmpty(message = "Please enter end date")
    @Column(columnDefinition = "DATETIME not null")
    private LocalDate endDate;

    @NotNull(message = "Enter tool id")
    @Column(columnDefinition = "int not null")
    private Integer toolId;

    @NotNull(message = "Enter tool id")
    @Column(columnDefinition = "int not null")
    private Integer ownerId;

    @Column(columnDefinition = "double ")
    private Double rentPrice;

}
