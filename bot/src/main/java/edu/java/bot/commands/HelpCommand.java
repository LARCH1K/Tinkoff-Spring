package edu.java.bot.commands;

import com.pengrad.telegrambot.model.Update;
import com.pengrad.telegrambot.request.SendMessage;
import edu.java.bot.entity.UserChat;
import edu.java.bot.repository.LinkTracker;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class HelpCommand implements Command {

    private final List<Command> listOfCommand;

    private final LinkTracker repository;

    @Override
    public String command() {
        return "/help";
    }

    @Override
    public String description() {
        return "Show the list of available commands";
    }

    @Override
    public SendMessage handle(Update update) {
        StringBuilder message = new StringBuilder("Available commands:\n");
        for (Command command : listOfCommand) {
            message.append(command.command()).append(" - ").append(command.description()).append("\n");
        }
        long chatId = update.message().chat().id();
        UserChat userChat = repository.findById(chatId);
//        if (userChat == null) {
//            return new SendMessage(chatId, "Please, register -- /start.");
//        }
        return new SendMessage(update.message().chat().id(), message.toString());
    }
}
