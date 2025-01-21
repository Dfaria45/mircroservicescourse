package com.ms.cards.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Data @Getter @Setter
@Schema(
        name = "ErrorResponse",
        description = "Schema of error response information"
)
public class ErrorResponseDto {

    private String apiPath;

    @Schema(
            description = "Error code"
    )
    private HttpStatus errorCode;

    public ErrorResponseDto(String apiPath, HttpStatus errorCode, String errorMessage, LocalDateTime errorTime) {
        this.apiPath = apiPath;
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
        this.errorTime = errorTime;
    }

    @Schema(
            description = "Error Message"
    )
    private String errorMessage;

    @Schema(
            description = "Error time"
    )
    private LocalDateTime errorTime;
}
