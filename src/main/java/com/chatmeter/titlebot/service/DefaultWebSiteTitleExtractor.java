package com.chatmeter.titlebot.service;

import lombok.extern.log4j.Log4j2;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

@Log4j2
public class DefaultWebSiteTitleExtractor implements WebSiteTitleExtractor{


    @Override
    public String extractTitle(String url) throws IOException {

        try {
            Document document = Jsoup.connect(url).get();
            String title = document.title();
            log.info("Title extracted for url:{} title:{}", url, title);

            return title;
        } catch (IOException e) {
            log.error("Error during extracting title from website url:{}", url, e);
            throw e;
        }
    }
}
