package com.haryridart.libraryapp.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Data
@Entity
@Table(name = "books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "book_id",unique = true,nullable = false)
    private String bookId;
    private String title;
    private String author;
    private String publisher;
    @Column(name = "published_date")
    private LocalDate publishedDate;
    @Column(name = "total_pages")
    private Integer totalPages;
    @OneToOne
    @JoinColumn(name = "borrow_id",referencedColumnName = "id")
    private Borrow borrow;

}
