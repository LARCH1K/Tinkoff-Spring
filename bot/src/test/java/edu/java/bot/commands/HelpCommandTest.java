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
public class HelpCommandTest {

    // Class to be tested
    @InjectMocks
    private HelpCommand helpCommand;

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
    @DisplayName("Check /help command")
    void helpCommandTest() {
        SendMessage actualResult = helpCommand.handle(update);
        String expectedString = expectedResultBuilder();

        Assertions.assertEquals(expectedString, actualResult.getParameters().get("text"));
        Assertions.assertEquals(chatId, actualResult.getParameters().get("chat_id"));
    }

    private String expectedResultBuilder() {
        StringBuilder message = new StringBuilder("Available commands:\n");

        message.append("/start - Register the user\n");
        message.append("/list - Show the list of tracked links\n");
        message.append("/track - Start link tracking\n");
        message.append("/untrack - Stop link tracking\n");
        return message.toString();
    }
}
