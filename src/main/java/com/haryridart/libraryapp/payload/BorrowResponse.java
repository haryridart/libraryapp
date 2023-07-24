package com.haryridart.libraryapp.payload;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class BorrowResponse {
    @ApiModelProperty(value = "Borrow response message",example = "Book successfully borrowed")
    private String message;
    private boolean success;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private BorrowDto borrow;
}
