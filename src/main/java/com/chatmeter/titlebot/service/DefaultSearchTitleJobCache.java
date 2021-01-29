package com.chatmeter.titlebot.service;

import com.chatmeter.titlebot.model.SearchTitleJob;

import java.util.HashMap;
import java.util.Map;

public class DefaultSearchTitleJobCache implements SearchTitleJobCache {

    private Map<String, SearchTitleJob> cache = new HashMap<>();

    @Override
    public void setJob(SearchTitleJob searchTitleJob) {

        this.cache.put(searchTitleJob.getJobId(), searchTitleJob);
    }

    @Override
    public SearchTitleJob getJob(String id) {
        return this.cache.get(id);
    }
}
