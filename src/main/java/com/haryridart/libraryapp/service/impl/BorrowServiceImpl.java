package com.haryridart.libraryapp.service.impl;

import com.haryridart.libraryapp.entity.Book;
import com.haryridart.libraryapp.entity.Borrow;
import com.haryridart.libraryapp.exception.ResourceNotFoundException;
import com.haryridart.libraryapp.payload.*;
import com.haryridart.libraryapp.repository.BookRepository;
import com.haryridart.libraryapp.repository.BorrowRepository;
import com.haryridart.libraryapp.service.BorrowService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BorrowServiceImpl implements BorrowService {
    @Autowired
    private BorrowRepository borrowRepository;
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private ModelMapper modelMapper;
    @Override
    public BorrowResponse borrowBook(BorrowDto borrowDto, String bookId) {
        Book book = bookRepository.findByBookId(bookId).orElseThrow(()->new ResourceNotFoundException("Book", "book ID",bookId));
        BorrowResponse borrowResponse = new BorrowResponse();
        Borrow borrow = book.getBorrow();
        if(borrow.getStatus() == 1){
            borrowResponse.setSuccess(false);
            borrowResponse.setMessage("Book is currently borrowed by other person");
        }else {
            borrow.setReturnDate(borrowDto.getReturnDate());
            borrow.setStatus(1);
            borrow.setReserveDate(borrowDto.getReserveDate());
            borrow.setBorrowerName(borrowDto.getBorrowerName());
            Borrow updatedBorrow = borrowRepository.save(borrow);
            borrowResponse.setSuccess(true);
            borrowResponse.setMessage("Book borrowed successfully!!");
            borrowResponse.setBorrow(modelMapper.map(updatedBorrow, BorrowDto.class));
        }
        return borrowResponse;
    }

    @Override
    public BorrowResponse updateStatus(BorrowDto borrowDto, String bookId) {
        Book book = bookRepository.findByBookId(bookId).orElseThrow(()->new ResourceNotFoundException("Book", "book ID",bookId));
        Borrow borrow = book.getBorrow();
        borrow.setReturnDate(borrowDto.getReturnDate());
        borrow.setStatus(borrowDto.getStatus());
        borrow.setReserveDate(borrowDto.getReserveDate());
        borrow.setBorrowerName(borrowDto.getBorrowerName());
        Borrow updatedBorrow = borrowRepository.save(borrow);
        BorrowResponse borrowResponse = new BorrowResponse();
        borrowResponse.setMessage("Book status successfully updated!!");
        borrowResponse.setSuccess(true);
        borrowResponse.setBorrow(modelMapper.map(updatedBorrow,BorrowDto.class));
        return borrowResponse;
    }
}
