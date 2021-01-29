package com.chatmeter.titlebot.service;

import com.chatmeter.titlebot.model.SearchTitleJob;

public interface JobQueue {

    void submitJob(SearchTitleJob searchTitleJob);

    SearchTitleJob getJob();

    int size();
}
