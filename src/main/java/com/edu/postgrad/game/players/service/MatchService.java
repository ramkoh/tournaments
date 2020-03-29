package com.edu.postgrad.game.players.service;

import java.util.List;

import com.edu.postgrad.game.common.Match;
import com.edu.postgrad.game.players.exception.MatchException;
import com.edu.postgrad.game.players.repository.MatchRepository;
import com.edu.postgrad.game.players.rest.feign.TeamsFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MatchService {

    @Autowired
    MatchRepository matchRepository;

    public Match saveMatch(final Match match){
        matchRepository.save(match);
        return match;
    }

    public Match getMatchById(final Long matchId){
        return matchRepository.findById(matchId).orElseThrow(()
                -> new MatchException(String.format("Match with id %s not found", matchId)));
    }

    public void deleteMatch(final Long matchId){
        final Match match = getMatchById(matchId);
        matchRepository.delete(match);
    }

    public List<Match> getAllMatches(){
        return matchRepository.findAll();
    }

    public List<Match> getMatchesByLocation(String location) {
        return matchRepository.findMatchesByLocation(location);
    }
}
