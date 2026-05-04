package com.cwdlimited.LearningRESTAPIs.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddStudentRequestDto {
    @NotBlank(message = "Name Is Required")
    @Size(min = 3, max = 30, message = "Name Must Be Between 3 And 30 Characters")
    private String name;

    @Email
    @NotBlank(message = "Email Is Required")
    private String email;
}
