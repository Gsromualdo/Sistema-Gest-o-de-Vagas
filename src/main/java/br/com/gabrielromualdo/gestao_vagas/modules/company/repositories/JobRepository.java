package br.com.gabrielromualdo.gestao_vagas.modules.company.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import br.com.gabrielromualdo.gestao_vagas.modules.company.entities.JobEntity;

@Service
public interface JobRepository extends JpaRepository<JobEntity, UUID>{

    
} 


