package com.system.LibraryApplication.core.entities;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "authors")
public class Authors {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "author_id")
    private Long authorId;

    @Column(name = "name_surname")
    private String nameSurname;

    @Column(name = "birth_date")
    private LocalDate birthDate;
}
