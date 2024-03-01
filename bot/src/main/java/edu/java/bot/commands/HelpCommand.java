package edu.java.bot.commands;

import com.pengrad.telegrambot.model.Update;
import com.pengrad.telegrambot.request.SendMessage;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class HelpCommand implements Command {

    final List<Command> listOfCommand;

    public HelpCommand(List<Command> listOfCommand) {
        this.listOfCommand = listOfCommand;
    }

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
        return new SendMessage(update.message().chat().id(), message.toString());
    }
}
