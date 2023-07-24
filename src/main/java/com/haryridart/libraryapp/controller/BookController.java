package com.haryridart.libraryapp.controller;

import com.haryridart.libraryapp.entity.Book;
import com.haryridart.libraryapp.payload.*;
import com.haryridart.libraryapp.payload.ApiResponse;
import com.haryridart.libraryapp.service.BookService;
import com.haryridart.libraryapp.service.BorrowService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Api(value = "CRUD REST APIs for Book resources")
@RestController
@RequestMapping("/api/v1/books")
public class BookController {
    @Autowired
    private BookService bookService;
    @Autowired
    private BorrowService borrowService;

    @GetMapping
    public ResponseEntity<List<BookDto>> getAllBooks(@RequestParam(name = "status",required = false) Integer status){
        return new ResponseEntity<>(bookService.getAllBooks(status),HttpStatus.OK) ;
    }
    @ApiOperation(value = "Add new Book REST API")
    @PostMapping
    public ResponseEntity<BookResponse> addBook(@RequestBody BookDto bookDto){
        return new ResponseEntity<>(bookService.addBook(bookDto), HttpStatus.CREATED);
    }
    @ApiOperation(value = "Delete Book by Book ID REST API")
    @DeleteMapping("/{bookId}")
    public ResponseEntity<BookResponse> deleteBook(@ApiParam(value = "Book ID", required = true,example = "A0001") @PathVariable("bookId") String bookId){
        return new ResponseEntity<>(bookService.deleteBook(bookId), HttpStatus.OK);
    }
    @ApiOperation(value = "Update Book Data REST API")
    @PutMapping("/{bookId}")
    public ResponseEntity<BookResponse> updateBookData(@RequestBody BookDto bookDto, @ApiParam(value = "Book ID", required = true,example = "A0001") @PathVariable("bookId") String bookId){
        return new ResponseEntity<>(bookService.updateBookData(bookDto,bookId),HttpStatus.OK);
    }
    @ApiOperation(value = "Update Book borrow status REST API")
    @PutMapping("/status/{bookId}")
    public ResponseEntity<BorrowResponse> updateBookStatus(@RequestBody BorrowDto borrowDto,
                                                           @ApiParam(value = "Book ID", required = true,example = "A0001") @PathVariable("bookId") String bookId){
        return new ResponseEntity<>(borrowService.updateStatus(borrowDto,bookId), HttpStatus.OK);
    }
}
