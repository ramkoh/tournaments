package com.edu.postgrad.game.players.rest.feign;

import com.edu.postgrad.game.common.Team;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("zuul-api-gateway")
public interface TeamsFeignClient {
    @GetMapping("/teams-service/ms/team/{name}")
    Team getTeamByName(@PathVariable String name);
}
