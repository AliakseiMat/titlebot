package com.chatmeter.titlebot.service;

import com.chatmeter.titlebot.model.SearchTitleJob;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.UUID;

@Service
public class FindTitleService {

    @Autowired
    private JobQueue jobQueue;
    @Autowired
    private SearchTitleJobCache searchTitleJobCache;

    public SearchTitleJob createSearchTileJob(String webSiteUrl) {

        SearchTitleJob searchTitleJob = new SearchTitleJob(
                webSiteUrl,
                UUID.randomUUID().toString(),
                new Date().getTime()
        );
        searchTitleJobCache.setJob(searchTitleJob);
        jobQueue.submitJob(searchTitleJob);

        return searchTitleJob;
    }
}
