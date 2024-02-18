package edu.java.bot.commands;

import com.pengrad.telegrambot.model.Chat;
import com.pengrad.telegrambot.model.Message;
import com.pengrad.telegrambot.model.Update;
import com.pengrad.telegrambot.request.SendMessage;
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
public class StartCommandTest {

    // Class to be tested
    @InjectMocks
    private StartCommand startCommand;

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
    @DisplayName("Check /start command")
    void startCommandTest() {
        SendMessage actualResult = startCommand.handle(update);
        String expectedString = "Welcome! You are now registered.";

        Assertions.assertEquals(expectedString, actualResult.getParameters().get("text"));
        Assertions.assertEquals(chatId, actualResult.getParameters().get("chat_id"));
    }
}
