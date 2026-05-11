package br.com.gabrielromualdo.gestao_vagas.modules.company.UseCases;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.gabrielromualdo.gestao_vagas.modules.company.entities.JobEntity;
import br.com.gabrielromualdo.gestao_vagas.modules.company.repositories.JobRepository;

public class ListAllJobsByCompanyUseCase {
    
    @Autowired
    private JobRepository jobRepository;

    public List<JobEntity> execute(UUID idCompany) {
        return this.jobRepository.findByCompanyId(idCompany);
    }
}   
