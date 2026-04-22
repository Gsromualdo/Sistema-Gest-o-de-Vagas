package br.com.gabrielromualdo.gestao_vagas.modules.company.UseCases;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.gabrielromualdo.gestao_vagas.modules.company.entities.JobEntity;
import br.com.gabrielromualdo.gestao_vagas.modules.company.repositories.JobRepository;
import lombok.NonNull;


@Service
public class CreateJobUseCase {
    
    @Autowired
    private JobRepository jobRepository;


    public JobEntity execute(@NonNull JobEntity jobEntity) {
       return this.jobRepository.save(jobEntity);
    }
}
