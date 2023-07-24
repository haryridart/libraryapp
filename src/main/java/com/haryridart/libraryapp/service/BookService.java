package com.haryridart.libraryapp.service;

import com.haryridart.libraryapp.payload.BookDto;
import com.haryridart.libraryapp.payload.BookResponse;

import java.util.List;

public interface BookService {
    List<BookDto> getAllBooks(Integer status);
    BookResponse addBook(BookDto bookDto);
    BookResponse updateBookData(BookDto bookDto, String bookId);
    BookResponse deleteBook(String bookId);
}
