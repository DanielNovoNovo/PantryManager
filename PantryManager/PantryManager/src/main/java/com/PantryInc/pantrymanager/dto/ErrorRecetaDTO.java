package com.PantryInc.pantrymanager.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ErrorRecetaDTO {

    private String error;
    private String mensaje;
}
