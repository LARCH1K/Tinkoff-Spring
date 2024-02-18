package edu.java.bot.messageProcessors;

import com.pengrad.telegrambot.model.Update;
import com.pengrad.telegrambot.request.SendMessage;
import edu.java.bot.commands.Command;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class UserMessageProcessorImpl implements UserMessageProcessor {
    private final List<Command> commands;

    public UserMessageProcessorImpl(List<Command> commands) {
        this.commands = commands;
    }

    public List<Command> commands() {
        return commands;
    }

    public SendMessage process(Update update) {

        String messageText = update.message().text();

        String unknownText = "Unknown command. Use /help for command list.";
        if (messageText == null || !messageText.startsWith("/")) {
            return new SendMessage(
                update.message().chat().id(),
                unknownText
            );
        }

        String commandText = messageText.split(" ")[0];

        for (Command command : commands) {
            if (command.command().equals(commandText)) {
                return command.handle(update);
            }
        }

        return new SendMessage(
            update.message().chat().id(),
            unknownText
        );
    }
}
