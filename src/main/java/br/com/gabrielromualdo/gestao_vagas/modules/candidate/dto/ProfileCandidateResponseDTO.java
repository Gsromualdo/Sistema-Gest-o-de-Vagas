package br.com.gabrielromualdo.gestao_vagas.modules.candidate.dto;

import java.util.UUID;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProfileCandidateResponseDTO {

    @Schema(example = "Desenvolvedora Java")
    private String description;

    @Schema(example = "Maria")
    private String username;

    @Schema(example = "Maria@gmail.com")
    private String email;
    private UUID id;

    @Schema(example = "Maria Souza")
    private String name;
}
