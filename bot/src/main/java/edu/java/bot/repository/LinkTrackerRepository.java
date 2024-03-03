package edu.java.bot.repository;

import edu.java.bot.entity.UserChat;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.springframework.stereotype.Repository;

@Repository
public class LinkTrackerRepository implements LinkTracker {
    private final Map<Long, UserChat> repository = new ConcurrentHashMap<>();

    @Override
    public UserChat findById(Long id) {
        return repository.get(id);
    }

    @Override
    public void save(UserChat telegramChat) {
        repository.put(telegramChat.getChatId(), telegramChat);

    }

    @Override
    public void delete(UserChat telegramChat) {
        repository.remove(telegramChat.getChatId());
    }
}
