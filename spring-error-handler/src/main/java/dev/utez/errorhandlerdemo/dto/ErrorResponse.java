package dev.utez.errorhandlerdemo.dto;

import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
public class ErrorResponse {
    String error;
    String detail;

}