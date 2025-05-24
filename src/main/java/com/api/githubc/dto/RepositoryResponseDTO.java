package com.api.githubc.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public record RepositoryResponseDTO(String id,
                                    @JsonProperty("html_url") String htmlUrl,
                                    @JsonProperty("private") boolean isPrivate) {
}
