package com.edu.postgrad.game.players;

import com.edu.postgrad.game.common.Tournament;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TournamentRepository extends JpaRepository<Tournament, Long> {
}
