package edu.java.bot.commands;

import com.pengrad.telegrambot.model.Update;
import com.pengrad.telegrambot.request.SendMessage;
import edu.java.bot.entity.UserChat;
import edu.java.bot.repository.LinkTracker;
import edu.java.bot.util.LinkUtil;
import java.net.URI;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class TrackCommand implements Command {

    private final LinkTracker repository;

    @Override
    public String command() {
        return "/track";
    }

    @Override
    public String description() {
        return "Start tracking a link";
    }

    @Override
    public SendMessage handle(Update update) {
        Long chatId = update.message().chat().id();
        UserChat userChat = repository.findById(chatId);
//        if (userChat == null) {
//            return new SendMessage(chatId, "Please, register -- /start.");
//        }

        String messageText = update.message().text();
        String[] tokens = messageText.split("\\s+");

        if (tokens.length < 2) {
            return new SendMessage(update.message().chat().id(), "Please provide a link to track.");
        }
        URI link = LinkUtil.parse(tokens[1]);
        if (link == null) {
            return new SendMessage(chatId, "Incorrect link");
        }
        List<String> links = userChat.getTrackingLinks();

        if (links.contains(link.toString())) {
            return new SendMessage(chatId, "Link is already tracked");

        }

        links.add(link.toString());
        repository.save(new UserChat(userChat.getChatId(), links));

        return new SendMessage(update.message().chat().id(), "Tracking started for the link: " + link);
    }
}