package com.haryridart.libraryapp.service;

import com.haryridart.libraryapp.payload.ApiResponse;
import com.haryridart.libraryapp.payload.BookResponse;
import com.haryridart.libraryapp.payload.BorrowDto;
import com.haryridart.libraryapp.payload.BorrowResponse;

public interface BorrowService {
    BorrowResponse borrowBook(BorrowDto borrowDto, String bookId);
    BorrowResponse updateStatus(BorrowDto borrowDto, String bookId);
}
