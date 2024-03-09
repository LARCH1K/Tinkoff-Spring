package edu.java.bot.commands;

import com.pengrad.telegrambot.model.Chat;
import com.pengrad.telegrambot.model.Message;
import com.pengrad.telegrambot.model.Update;
import com.pengrad.telegrambot.request.SendMessage;
import edu.java.bot.BotApplication;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.mockito.Mockito.when;

@SpringBootTest(classes = {BotApplication.class})
public class HelpCommandTest {

    // Dependencies (will be mocked)
    @Mock
    private Update update;
    @Mock
    private Message message;
    @Mock
    private Chat chat;

    final long chatId = 123L;

    @Autowired
    private List<Command> listOfCommand;

    @Autowired
    private HelpCommand helpCommand;

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
        for (Command command : listOfCommand) {
            if (!command.command().equals("/help")) {
                message.append(command.command()).append(" - ").append(command.description()).append("\n");
            }
        }
        return message.toString();
    }
}
