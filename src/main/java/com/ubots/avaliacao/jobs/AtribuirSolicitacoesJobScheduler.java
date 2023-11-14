package com.ubots.avaliacao.jobs;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;

public class AtribuirSolicitacoesJobScheduler {

    @Autowired
    private JobLauncher jobLauncher;

    @Autowired
    private Job atribuirSolicitacoesJob;

    @Scheduled(cron = "0 */5 * * * ?") // Executar a cada 5 minutos
    public void executeJob() throws Exception {
        JobParameters jobParameters = new JobParametersBuilder()
                .addLong("time", System.currentTimeMillis())
                .toJobParameters();

        jobLauncher.run(atribuirSolicitacoesJob, jobParameters);
    }
}
