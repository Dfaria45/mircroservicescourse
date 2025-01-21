package com.ms.accounts.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.*;

@Data @AllArgsConstructor @NoArgsConstructor @Getter @Setter @ToString
@Schema(
        name = "Customer",
        description = "Schema to hold Customer and Account information"
)
public class CustomerDto {

    @Schema(
            description = "Name of the customer", example = "John Doe"
    )
    @NotEmpty(message = "Name can not be a null or empty")
    @Size(min= 3, max = 30, message = "Name must be between 3 and 30 characters")
    private String name;

    @Schema(
            description = "Email of the customer", example = "test@test.com"
    )
    @NotEmpty(message = "Email can not be a null or empty")
    @Email(message = "Please enter a valid email address")
    private String email;

    @Schema(
            description = "Mobile Number of the customer", example = "123456789"
    )
    @Pattern(regexp="(^$|[0-9]{9})" , message = "Please enter a valid mobile number")
    private String mobileNumber;

    @Schema(
            description = "Account details of customer"
    )
    private AccountsDto accountsDto;

}
