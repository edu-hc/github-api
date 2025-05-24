package com.api.githubc.controller;

import com.api.githubc.client.GithubClient;
import com.api.githubc.dto.RepositoryResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1")
public class GithubController {

    private final GithubClient githubClient;

    @Autowired
    public GithubController(GithubClient githubClient) {
        this.githubClient = githubClient;
    }

    @GetMapping("/repos")
    public ResponseEntity<List<RepositoryResponseDTO>> getRepos(@RequestHeader("token") String token) {

        var repos = githubClient.getRepos("Bearer " + token, null, "public");

        return ResponseEntity.ok(repos);
    }
}
