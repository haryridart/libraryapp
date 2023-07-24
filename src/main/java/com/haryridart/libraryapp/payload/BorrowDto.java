package com.haryridart.libraryapp.payload;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDate;
@ApiModel(description = "Borrow book model information")
@Data
public class BorrowDto {
    @ApiModelProperty(value = "Borrow database id", hidden = true)
    private Integer id;
    @ApiModelProperty(value = "Reserve date of the book",example = "13-10-2022")
    @JsonFormat(pattern="dd-MM-yyy")
    private LocalDate reserveDate;
    @ApiModelProperty(value = "Return date of the book",example = "20-10-2022")
    @JsonFormat(pattern="dd-MM-yyy")
    private LocalDate returnDate;
    @ApiModelProperty(value = "Borrower name of the book",example = "Hary Ridart")
    private String borrowerName;
    @ApiModelProperty(value = "Availability of the book : 1 (Borrowed), 0 (Available)", example = "1")
    private Integer status;
}
