package week3.week3.board.dto.request;

import jakarta.validation.constraints.NotBlank;

public record BoardCreateRequest (
        @NotBlank
        String name,
        @NotBlank
        String description){
}
