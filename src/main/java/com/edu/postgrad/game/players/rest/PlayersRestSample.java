package com.edu.postgrad.game.players.rest;

import com.edu.postgrad.game.common.Team;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping(path = "/tournaments", produces = "application/json")
public class PlayersRestSample {
    @Autowired
    RestTemplate restTemplate;

    @GetMapping("hello")
    public ResponseEntity<Team> hello() {
        final String uri = "http://teams-service/ms/teams/1";
        final ResponseEntity<Team> teamResponseEntity = restTemplate.exchange(uri, HttpMethod.GET, null,
                Team.class);
        return teamResponseEntity;
    }
}
