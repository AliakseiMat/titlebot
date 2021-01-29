package com.chatmeter.titlebot.scheduler;


import com.chatmeter.titlebot.model.SearchTitleJob;
import com.chatmeter.titlebot.service.JobQueue;
import com.chatmeter.titlebot.service.SearchTitleJobCache;
import com.chatmeter.titlebot.service.WebSiteTitleExtractor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.concurrent.CompletableFuture;

@Log4j2
@Component
public class JobExecutor {

    @Autowired
    private JobQueue jobQueue;
    @Autowired
    private SearchTitleJobCache searchTitleJobCache;
    @Autowired
    private WebSiteTitleExtractor webSiteTitleExtractor;

    @Scheduled(fixedDelay = 1000)
    public void reportCurrentTime() {

        while (jobQueue.size()>0){
            SearchTitleJob job = jobQueue.getJob();
            log.info("Execute job id:{}", job.getJobId());
            CompletableFuture.runAsync(new Runnable() {
                @Override
                public void run() {
                    job.setStatus(SearchTitleJob.JobStatus.IN_PROGRESS);
                    searchTitleJobCache.setJob(job);
                    log.info("Jod is processing id:{}", job.getJobId());
                    try {
                        String title = webSiteTitleExtractor.extractTitle(job.getWebSiteUrl());
                        job.setStatus(SearchTitleJob.JobStatus.DONE);
                        job.setTitle(title);
                    } catch (IOException e) {
                        job.setError("Error during extracting title");
                        job.setStatus(SearchTitleJob.JobStatus.ERROR);
                    }
                    log.info("Jod is done job:{}", job.toString());
                    searchTitleJobCache.setJob(job);
                }
            });
        }
    }
}
