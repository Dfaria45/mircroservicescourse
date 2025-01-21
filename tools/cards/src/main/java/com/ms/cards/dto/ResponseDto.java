package com.ms.cards.dto;

import lombok.AllArgsConstructor;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@Schema(
        name = "Response",
        description = "Schema to hold successful response information"
)

@Data
@Getter
@Setter
@ToString
public class ResponseDto {

    public ResponseDto(String statusCode, String statusMsg) {
        this.statusCode = statusCode;
        this.statusMsg = statusMsg;
    }

    @Schema(
            description = "Status code in the response"
    )
    private String statusCode;

    @Schema(
            description = "Status message in the response"
    )
    private String statusMsg;

}