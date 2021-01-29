package com.chatmeter.titlebot.service;

import java.io.IOException;

public interface WebSiteTitleExtractor {

    String extractTitle(String url) throws IOException;
}
