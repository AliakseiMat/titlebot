package com.chatmeter.titlebot.service;

import com.chatmeter.titlebot.model.SearchTitleJob;

import java.util.Deque;
import java.util.LinkedList;

public class DefaultJobQueue implements JobQueue {

    private Deque<SearchTitleJob> deque = new LinkedList<SearchTitleJob>();

    @Override
    public void submitJob(SearchTitleJob searchTitleJob) {

        this.deque.addLast(searchTitleJob);
    }

    @Override
    public synchronized SearchTitleJob getJob() {

        if (this.deque.size() == 0){
            return null;
        }
        return this.deque.pop();
    }

    @Override
    public int size() {

        return this.deque.size();
    }
}
