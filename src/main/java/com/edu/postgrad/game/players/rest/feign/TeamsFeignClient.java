package com.edu.postgrad.game.players.rest.feign;

import com.edu.postgrad.game.common.Team;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("teams-service")
public interface TeamsFeignClient {
    @GetMapping("ms/teams/{id}")
    Team getTeamById(@PathVariable Long id);
}
