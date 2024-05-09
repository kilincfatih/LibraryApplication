package com.system.LibraryApplication.entities.concretes;

import com.system.LibraryApplication.core.entities.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDate;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "books")
public class Books extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "book_id")
    private Long bookId;

    @Column(name = "isbn")
    private String isbn;

    @Column(name = "book_name")
    private String bookName;

    @Column(name = "publication_date")
    private LocalDate publicationDate;

    @Column(name = "language")
    private String language;

    @Column(name = "page_count")
    private Integer pageCount;

}
