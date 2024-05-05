package com.system.LibraryApplication.core.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "book_author")
public class BookAuthor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long book_author_id;

    @ManyToOne
    @JoinColumn(name = "book_id")
    private Books books;

    @ManyToOne
    @JoinColumn(name = "author_id")
    private Authors authors;
}
