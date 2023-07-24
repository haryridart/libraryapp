package com.haryridart.libraryapp.payload;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class BookResponse {
    @ApiModelProperty(value = "Book response message",example = "Book successfully created")
    private String message;
    private boolean success;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private BookDto book;
}
