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
@Table(name = "members")
public class Members extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    private Long memberId;

    @Column(name = "name_surname")
    private String nameSurname;

    @Column(name = "e_mail")
    private String email;

    @Column(name = "start_date")
    private LocalDate startDate;
}
