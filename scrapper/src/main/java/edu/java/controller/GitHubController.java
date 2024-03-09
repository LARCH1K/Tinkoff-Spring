package edu.java.controller;

import edu.java.client.GitHubClient;
import edu.java.dto.GitHubResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/github")
public class GitHubController {

    private final GitHubClient gitHubIssueClient;

    @GetMapping("/issue/{owner}/{repo}/{issueNumber}")
    public GitHubResponse getGitHubIssue(
        @PathVariable String owner,
        @PathVariable String repo,
        @PathVariable long issueNumber
    ) {
        return gitHubIssueClient.getIssue(owner, repo, issueNumber);
    }
}
