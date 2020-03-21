package com.edu.postgrad.game.players.repository;

import com.edu.postgrad.game.common.Match;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MatchRepository extends JpaRepository<Match, Long> {
}
