package com.api.githubc.client;

import com.api.githubc.dto.RepositoryResponseDTO;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.service.annotation.GetExchange;

import java.util.List;

public interface GithubClient {

    @GetExchange("/user/repos")
    public List<RepositoryResponseDTO> getRepos(@RequestHeader("Authorization") String token,
                                                @RequestHeader(value = "X-Github-Api-Version", defaultValue = "2022-11-28")
                                                String apiVersion,
                                                @RequestParam("visibility") String visibility);
}
