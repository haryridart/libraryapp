package com.haryridart.libraryapp.payload;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ApiResponse {
    @ApiModelProperty(value = "General Api response message",example = "Book is successfully deleted")
    private String message;
    private boolean success;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private BorrowDto borrow_detail;

    public ApiResponse(String messaage, boolean success) {
    }
}
