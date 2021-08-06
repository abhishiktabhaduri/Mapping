package com.mapping.entity;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="library_id",columnDefinition = "int",nullable = false)
    private int libraryId;

    @Column(name = "book_name", columnDefinition = "varchar(512)")
    private String bookName;

    @Column(name = "author", columnDefinition = "varchar(512)")
    private String author;

    @Column(name = "published_by", columnDefinition = "varchar(512)")
    private String publishedBy;
}