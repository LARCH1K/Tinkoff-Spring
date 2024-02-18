package edu.java.bot.commands;

import com.pengrad.telegrambot.model.Chat;
import com.pengrad.telegrambot.model.Message;
import com.pengrad.telegrambot.model.Update;
import com.pengrad.telegrambot.request.SendMessage;
import edu.java.bot.models.LinkTracker;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class TrackCommandTest {

    // Class to be tested
    @InjectMocks
    private TrackCommand trackCommand;

    @InjectMocks
    private LinkTracker linkTracker;

    // Dependencies (will be mocked)

    @Mock
    private Update update;
    @Mock
    private Message message;
    @Mock
    private Chat chat;

    final long chatId = 123L;

    @BeforeEach
    void init() {
        when(update.message()).thenReturn(message);
        when(message.chat()).thenReturn(chat);
        when(chat.id()).thenReturn(chatId);
    }

    @Test
    @DisplayName("Check /track command")
    void trackCommandTest() {
        when(message.text()).thenReturn("/track https://example.com");

        SendMessage actualResult = trackCommand.handle(update);
        String expectedString = "Tracking started for the link: https://example.com";
        String expectedLink = "https://example.com";

        Assertions.assertEquals(expectedString, actualResult.getParameters().get("text"));
        Assertions.assertEquals(expectedLink, linkTracker.getTrackedLinks(chatId).get(0));
        Assertions.assertEquals(chatId, actualResult.getParameters().get("chat_id"));
    }
}
