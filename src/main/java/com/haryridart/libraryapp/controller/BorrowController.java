package com.haryridart.libraryapp.controller;

import com.haryridart.libraryapp.payload.ApiResponse;
import com.haryridart.libraryapp.payload.BookResponse;
import com.haryridart.libraryapp.payload.BorrowDto;
import com.haryridart.libraryapp.payload.BorrowResponse;
import com.haryridart.libraryapp.service.BorrowService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@Api(value = "REST APIs for Borrow process")
@RestController
@RequestMapping("/api/v1/borrows")
public class BorrowController {
    @Autowired
    private BorrowService borrowService;
    @ApiOperation(value = "Borrow book REST API")
    @PutMapping("/{bookId}")
    public ResponseEntity<BorrowResponse> borrowBook(@RequestBody BorrowDto borrowDto,
                                                     @ApiParam(value = "Book ID", required = true,example = "A0001") @PathVariable("bookId") String bookId){
        return new ResponseEntity<>(borrowService.borrowBook(borrowDto,bookId), HttpStatus.OK);
    }
}
