package com.chatmeter.titlebot.service;

import com.chatmeter.titlebot.model.SearchTitleJob;

public interface SearchTitleJobCache {

    void setJob(SearchTitleJob searchTitleJob);

    SearchTitleJob getJob(String id);
}
