package edu.java.configuration;

import edu.java.client.GitHubClient;
import edu.java.client.StackOverflowClient;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class ClientConfiguration {
    private final ApplicationConfig config;

    @Bean
    public GitHubClient gitHubClient() {
        return new GitHubClient(config.linkClient().github());
    }

    @Bean
    public StackOverflowClient stackOverflowClient() {
        return new StackOverflowClient(config.linkClient().stackOverflow());
    }
}