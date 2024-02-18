package edu.java.bot.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.springframework.stereotype.Component;

@Component
public class LinkTracker {

    private static Map<Long, List<String>> trackedLinksMap;

    public LinkTracker() {
        trackedLinksMap = new ConcurrentHashMap<>();
    }

    public static void trackLink(long chatId, String link) {
        trackedLinksMap.computeIfAbsent(chatId, k -> new ArrayList<>()).add(link);
    }

    public List<String> getTrackedLinks(long chatId) {
        return trackedLinksMap.getOrDefault(chatId, List.of());
    }

    public static void untrackLink(long chatId, String link) {
        trackedLinksMap.computeIfPresent(chatId, (k, v) -> {
            v.remove(link);
            return v;
        });
    }
}
