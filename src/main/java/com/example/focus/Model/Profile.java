
package com.example.focus.Model;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Profile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    @Size(max = 500, message = "Description cannot exceed 500 characters")
    @Column(columnDefinition = "varchar(50) not null")
    private String description;

    @Min(value = 0, message = "Number of posts cannot be negative")
    @Column(columnDefinition = "int not null")
    private Integer numberOfPosts;

    @Pattern(regexp = "^(https?|ftp)://[^\s/$.?#].[^\s]*$", message = "Image URL must be valid (http, https, or ftp)")
    @Column(columnDefinition = "varchar not null")
    private String image;  // URL of the image

    @OneToOne
    @JoinColumn(name = "photographer_id")
    @JsonIgnore
    private Photographer photographer;

    @OneToOne
    @JoinColumn(name = "editor_id")
    @JsonIgnore
    private Editor editor;

    @OneToMany(cascade = CascadeType.ALL , mappedBy = "media")
    private Set<Media> medias;
}

