package com.edu.postgrad.game.players.rest;

import java.util.List;

import com.edu.postgrad.game.common.Match;
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

@RestController
public class MatchContoller {

    @Autowired
    MatchService matchService;

    @PostMapping("match")
    public ResponseEntity<Match> createMatch(@RequestBody  Match match){
        matchService.saveMatch(match);
        return new ResponseEntity<Match>(match, HttpStatus.OK);
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

    @GetMapping("match")
    public ResponseEntity<List<Match>> viewAllMatches(){
        List<Match> matches = matchService.getAllMatches();
        return new ResponseEntity<List<Match>>(matches, HttpStatus.OK);
    }
}
