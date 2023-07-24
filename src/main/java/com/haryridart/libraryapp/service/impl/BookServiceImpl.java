package com.haryridart.libraryapp.service.impl;

import com.haryridart.libraryapp.entity.Book;
import com.haryridart.libraryapp.entity.Borrow;
import com.haryridart.libraryapp.exception.ResourceNotFoundException;
import com.haryridart.libraryapp.payload.BookDto;
import com.haryridart.libraryapp.payload.BookResponse;
import com.haryridart.libraryapp.repository.BookRepository;
import com.haryridart.libraryapp.repository.BorrowRepository;
import com.haryridart.libraryapp.service.BookService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private BorrowRepository borrowRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<BookDto> getAllBooks(Integer status) {
        List<Book> books = new ArrayList<>();
        if(status!=null){
             books= bookRepository.findAllByStatus(status);
        }else {
            books = bookRepository.findAll();
        }
        return books.stream().map(book->modelMapper.map(book, BookDto.class)).collect(Collectors.toList());
    }

    @Override
    public BookResponse addBook(BookDto bookDto) {
        Borrow borrow = new Borrow();
        borrow.setStatus(0);
        Borrow createdBorrow = borrowRepository.save(borrow);
        Book book = new Book();
        book.setBookId(bookDto.getBookId());
        book.setTitle(bookDto.getTitle());
        book.setAuthor(bookDto.getAuthor());
        book.setPublisher(bookDto.getPublisher());
        book.setPublishedDate(bookDto.getPublishedDate());
        book.setTotalPages(bookDto.getTotalPages());
        book.setBorrow(createdBorrow);
        BookResponse bookResponse = new BookResponse();
        try{
            Book createdBook = bookRepository.save(book);
            bookResponse.setMessage("Book successfully created");
            bookResponse.setSuccess(true);
            bookResponse.setBook(modelMapper.map(createdBook, BookDto.class));

        }catch (DataIntegrityViolationException e){
            bookResponse.setMessage("Book with book ID : " + bookDto.getBookId()+ " already exist");
            bookResponse.setSuccess(false);
        }
        return bookResponse;
    }

    @Override
    public BookResponse updateBookData(BookDto bookDto, String bookId) {
        Book book = bookRepository.findByBookId(bookId).orElseThrow(()-> new ResourceNotFoundException("Book", "book ID",bookId));
        book.setBookId(bookDto.getBookId());
        book.setTitle(bookDto.getTitle());
        book.setAuthor(bookDto.getAuthor());
        book.setPublisher(bookDto.getPublisher());
        book.setPublishedDate(bookDto.getPublishedDate());
        book.setTotalPages(bookDto.getTotalPages());
        BookResponse bookResponse = new BookResponse();
        bookResponse.setMessage("Book not found with book ID :" + bookId);
        try{
            Book updatedBook = bookRepository.save(book);
            bookResponse.setMessage("Book successfully updated!!");
            bookResponse.setSuccess(true);
            bookResponse.setBook(modelMapper.map(updatedBook,BookDto.class));
        }catch (DataIntegrityViolationException e){
            bookResponse.setMessage("Book with book ID : " + bookDto.getBookId()+ " already exist");
            bookResponse.setSuccess(false);
        }
        return bookResponse;
    }

    @Override
    public BookResponse deleteBook(String bookId) {
        Book book = bookRepository.findByBookId(bookId).orElseThrow(()->new ResourceNotFoundException("Book", "book ID",bookId));
        bookRepository.delete(book);
        borrowRepository.deleteById(book.getId());
        BookResponse bookResponse= new BookResponse();
        bookResponse.setMessage("Book is successfully deleted");
        bookResponse.setSuccess(true);
        return bookResponse;
    }
}
