package br.com.gabrielromualdo.gestao_vagas.modules.candidate.useCases;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.gabrielromualdo.gestao_vagas.exceptions.JobNotFoundException;
import br.com.gabrielromualdo.gestao_vagas.exceptions.UserNotFoundException;
import br.com.gabrielromualdo.gestao_vagas.modules.candidate.CandidateRepository;
import br.com.gabrielromualdo.gestao_vagas.modules.candidate.entity.ApplyJobEntity;
import br.com.gabrielromualdo.gestao_vagas.modules.candidate.repository.ApplyJobRepository;
import br.com.gabrielromualdo.gestao_vagas.modules.company.repositories.JobRepository;


@Service
public class ApplyJobCandidateUseCase {
    

    @Autowired
    private CandidateRepository candidateRepository;

    @Autowired
    private JobRepository  jobRepository;

    @Autowired
    ApplyJobRepository applyJobRepository;
    
    public ApplyJobEntity execute(UUID idcandidate, UUID idJob) {
        //verificar se o candidato existe
        this.candidateRepository.findById(idcandidate)
        .orElseThrow(() -> {
            throw new UserNotFoundException();
        });

        //verificar se a vaga existe

        this.jobRepository.findById(idJob)
        .orElseThrow(() ->{
            throw new JobNotFoundException();
        });

        //candidato se inscreve na vaga

        var applyJob = ApplyJobEntity.builder()
        .candidateId(idcandidate)
        .jobId(idJob).build();
       applyJob = applyJobRepository.save(applyJob);

       return applyJob;
    }
}
