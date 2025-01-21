package com.ms.accounts.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data @AllArgsConstructor @Getter @Setter
@Schema(
        name = "Response",
        description = "Schema of successful response information"
)
public class ResponseDto {

    @Schema(
            description = "Status code"
    )
    private String statusCode;

    @Schema(
            description = "Status Message"
    )
    private String statusMsg;

}