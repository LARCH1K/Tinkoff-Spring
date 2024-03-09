package edu.java.bot.configuration;

import edu.java.bot.commands.Command;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CommandConfig {

    public final List<Command> commands;

    @Autowired
    public CommandConfig(List<Command> commands) {
        this.commands = commands;
    }
}
