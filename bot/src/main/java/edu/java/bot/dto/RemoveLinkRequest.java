package edu.java.bot.dto;

import java.net.URI;
import org.jetbrains.annotations.NotNull;

public record RemoveLinkRequest(
    @NotNull URI link
) {
}
