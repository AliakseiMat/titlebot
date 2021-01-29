package com.chatmeter.titlebot.controller.api;

import com.chatmeter.titlebot.model.SearchTitleJob;
import com.chatmeter.titlebot.service.FindTitleService;
import com.fasterxml.jackson.databind.JsonNode;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Log4j2
@RestController
public class FindTitleController {

    @Autowired
    private FindTitleService findTitleService;

    @PostMapping("/find/title")
    public SearchTitleJob findTitle(@RequestBody JsonNode jsonBody) {

        log.info("Searching title for {}", jsonBody.toString());
        return findTitleService.createSearchTileJob(jsonBody.get("url").asText());
    }
}
