package com.chatmeter.titlebot.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ToString
@RequiredArgsConstructor
@Getter
@Setter
public class SearchTitleJob {

    private final String webSiteUrl;
    private final String jobId;
    private final Long createTime;
    private JobStatus status = JobStatus.CREATED;
    private String title = null;
    private String error = null;

    public enum JobStatus{
        CREATED, IN_PROGRESS, DONE, ERROR
    }
}
