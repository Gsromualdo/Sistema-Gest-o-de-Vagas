package br.com.gabrielromualdo.gestao_vagas.modules.candidate;

import java.time.LocalDateTime;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.validator.constraints.Length;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity(name = "candidate")
public class CandidateEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Schema(example = "Maria Souza",requiredMode = Schema.RequiredMode.REQUIRED, description = "nome do candidato")
    private String name;

    @NotBlank()
    @Pattern(regexp = "^\\S+", message = "O campo [username] não pode conter espaços em branco")
     @Schema(example = "Maria",requiredMode = Schema.RequiredMode.REQUIRED, description = "Username do candidato")
    private String username;

    @Email(message = "O campo email deve conter um email valido")
    @Schema(example = "Maria@gmail.com",requiredMode = Schema.RequiredMode.REQUIRED, description = "Email do candidato")  
    private String email;

    @Length(min = 10, max = 100, message = "A senha deve conter entre 10 e 200 caracteres")
    @Schema(example = "123456789", minLength = 10,maxLength = 100,requiredMode = Schema.RequiredMode.REQUIRED, description = "senha do candidato")
    private String password;

    @Schema(example = "Desenvolvedora Java",requiredMode = Schema.RequiredMode.REQUIRED, description = "Breve descrição do candidato")
    private String description;
    private String curriculum;

    @CreationTimestamp
    private LocalDateTime createdAt;

    public void setName(String name) {
        this.name = name;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setDescription(String description) {
        this.description = description;
        }

    public void setCurriculum(String curriculum) {
        this.curriculum = curriculum;
     }
     public void setId(UUID id) {
        this.id = id;
    }

    public UUID getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getDescription() {
        return description;
    }

    public String getCurriculum() {
        return curriculum;
    }

}
