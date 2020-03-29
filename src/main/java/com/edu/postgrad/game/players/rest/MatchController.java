package com.edu.postgrad.game.players.rest;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import com.edu.postgrad.game.common.Match;
import com.edu.postgrad.game.players.config.MatchConfiguration;
import com.edu.postgrad.game.players.exception.MatchException;
import com.edu.postgrad.game.players.rest.feign.TeamsFeignClient;
import com.edu.postgrad.game.players.service.MatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class MatchController {
    @Autowired
    TeamsFeignClient teamsFeignClient;
    @Autowired
    MatchService matchService;
    @Autowired
    MatchConfiguration matchConfiguration;

    @PostMapping("match")
    public ResponseEntity<Match> createMatch(@RequestBody  Match match){
        try {
            teamsFeignClient.getTeamByName(match.getTeam1());
            teamsFeignClient.getTeamByName(match.getTeam2());
        }catch (Exception e){
            throw new MatchException("Invalid team name provided.");
        }
        matchService.saveMatch(match);
        //Create resource location
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(match.getId())
                .toUri();
        return ResponseEntity.created(location).build();
    }

    @GetMapping("match/{id}")
    public ResponseEntity<Match> viewMatch(@PathVariable  Long id){
        final Match match = matchService.getMatchById(id);
        return new ResponseEntity<Match>(match, HttpStatus.OK);
    }

    @DeleteMapping("match/{id}")
    public ResponseEntity deleteMatch(final Long id){
        matchService.deleteMatch(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @PutMapping("match/{id}")
    public ResponseEntity updateMatch(final @RequestBody Match match){
        matchService.saveMatch(match);
        return new ResponseEntity<Match>(match, HttpStatus.OK);
    }

    @GetMapping("matches")
    public List<Match> viewAllMatches(){
        List<Match> matches = matchService.getAllMatches();
        return matches;
    }

    @GetMapping(value = {"match/location", "match/location/{location}"})
    public List<Match> getMatchByLocation(@PathVariable(required = false) Optional<String> location){
        List<Match> matches = matchService.getMatchesByLocation( location.orElse(matchConfiguration.getLocation()));
        return matches;
    }
}
