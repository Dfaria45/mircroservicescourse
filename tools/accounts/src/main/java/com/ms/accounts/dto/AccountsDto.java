package com.ms.accounts.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.*;

@Data @AllArgsConstructor @Setter @Getter @NoArgsConstructor
@Schema(
        name = "Accounts",
        description = "Schema of Account information"
)
public class AccountsDto {

    @Schema(
            description = "Account Number of EazyBank account"
    )
    @NotEmpty
    @Pattern(regexp="(^$|[0-9]{10})" , message = "Account Number must be 10 digits")
    private Long accountNumber;

    @Schema(
            description = "Account type", example = "Savings"
    )
    @NotEmpty(message = "Account Type can not be a null or empty")
    private String accountType;

    @Schema(
            description = "EazyBank Address"
    )
    @NotEmpty(message = "Branch Address can not be a null or empty")
    private String branchAddress;

}
