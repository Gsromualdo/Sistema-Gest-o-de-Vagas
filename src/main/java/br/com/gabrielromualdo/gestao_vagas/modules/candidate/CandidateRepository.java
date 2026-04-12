package br.com.gabrielromualdo.gestao_vagas.modules.candidate;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;



public interface CandidateRepository extends JpaRepository<CandidateEntity, UUID>{
    Optional<CandidateEntity> findByUsernameOrEmail(String username, String email); //consulta sql para encontrar o nome de usuario
    Optional<CandidateEntity>  findByUsername(String username);
 }
