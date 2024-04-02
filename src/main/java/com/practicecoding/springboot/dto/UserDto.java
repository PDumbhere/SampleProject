package com.practicecoding.springboot.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Schema(
        description = "UserDto Model Information"
)
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {

    private Long id;

    @Schema(
            description = "User First Name"
    )
    // User firstName should not be null or empty
    @NotEmpty(message = "User firstName should not be null or empty")
    private String firstName;

    @Schema(
            description = "User Last Name"
    )
    // User lastName should not be null or empty
    @NotEmpty(message = "User lastName should not be null or empty")
    private String lastName;

    @Schema(
            description = "User Email Address"
    )
    // User email should not be null or empty
    // Email address should be valid
    @NotEmpty(message = "Email Address should not be null or empty")
    @Email(message = "Email Address should be written in correct format")
    private String email;
}
