package com.chatmeter.titlebot;

import com.chatmeter.titlebot.service.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class TitlebotApplication {

    public static void main(String[] args) {
        SpringApplication.run(TitlebotApplication.class, args);
    }

    @Bean
    public JobQueue jobQueue() {

        return new DefaultJobQueue();
    }

    @Bean
    public SearchTitleJobCache searchTitleJobCache() {

        return new DefaultSearchTitleJobCache();
    }

    @Bean
    public WebSiteTitleExtractor webSiteTitleExtractor() {

        return new DefaultWebSiteTitleExtractor();
    }
}
