package com.haryridart.libraryapp.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Data
@Entity
@Table(name = "borrows")
public class Borrow {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "return_date")
    private LocalDate returnDate;
    @Column(name = "reserve_date")
    private LocalDate reserveDate;
    @Column(name = "borrower_name")
    private String borrowerName;
    private Integer status;
}
