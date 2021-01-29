package com.chatmeter.titlebot.controller.api;

import com.chatmeter.titlebot.model.SearchTitleJob;
import com.chatmeter.titlebot.service.SearchTitleJobCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GetJobResultController {

    @Autowired
    private SearchTitleJobCache searchTitleJobCache;

    @GetMapping("/search/title/job/{jobId}")
    public SearchTitleJob getJobResult(@PathVariable("jobId") String jobId) {

        return searchTitleJobCache.getJob(jobId);
    }
}
