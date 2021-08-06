package com.mapping.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Library  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "library_name", columnDefinition = "varchar(512)")
    private String libraryName;

    @Column(name = "micromarket", columnDefinition = "varchar(512)")
    private String micromarket;

    @Column(name = "city", columnDefinition = "varchar(512)")
    private String city;

    @Column(name = "country", columnDefinition = "varchar(512)")
    private String country;

    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name = "library_id")
    private Set<Book> books = new HashSet<>();
}