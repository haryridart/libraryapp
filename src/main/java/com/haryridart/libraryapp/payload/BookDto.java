package com.haryridart.libraryapp.payload;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Column;
import java.time.LocalDate;
import java.util.Date;
@ApiModel(description = "Book model information")
@Data
public class BookDto {
    @ApiModelProperty(value = "Book database id", hidden = true)
    private Integer id;
    @ApiModelProperty(value = "Book ID", example = "A0001",required = true)
    private String bookId;
    @ApiModelProperty(value = "Title of the book",example = "Harry Potter dan Batu Bertuah")
    private String title;
    @ApiModelProperty(value = "Author of the book",example = "J.K Rowling")
    private String author;
    @ApiModelProperty(value = "Publisher of the book",example = "Gramedia")
    private String publisher;
    @ApiModelProperty(value = "Published date of the book",example = "29-06-1997")
    @JsonFormat(pattern="dd-MM-yyy")
    private LocalDate publishedDate;
    @ApiModelProperty(value = "Total pages number of the book",example = "384")
    private Integer totalPages;
}
