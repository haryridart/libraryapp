package com.haryridart.libraryapp.repository;

import com.haryridart.libraryapp.entity.Borrow;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BorrowRepository extends JpaRepository<Borrow,Integer> {
}
