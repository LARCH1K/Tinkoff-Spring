package edu.java.repository.jdbc;

import edu.java.entity.TelegramChat;
import edu.java.repository.EntityRepository;
import java.util.Collection;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

@RequiredArgsConstructor
public class JdbcTelegramChatRepository implements EntityRepository<TelegramChat> {
    private static final String ADD_QUERY = "INSERT INTO telegram_chat (id, registered_at) VALUES (?, ?) RETURNING *";
    private static final String DELETE_QUERY = "DELETE FROM telegram_chat WHERE id=? RETURNING *";
    private static final String SELECT_ALL = "SELECT * FROM telegram_chat";

    private final JdbcTemplate jdbcTemplate;

    private final BeanPropertyRowMapper<TelegramChat> beanPropertyRowMapper;

    public JdbcTelegramChatRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        this.beanPropertyRowMapper = new BeanPropertyRowMapper<>(TelegramChat.class);
    }

    @Override
    public TelegramChat add(TelegramChat entity) {
        return jdbcTemplate.queryForObject(
            ADD_QUERY,
            beanPropertyRowMapper,
            entity.getId(),
            entity.getRegisteredAt()
        );
    }

    @Override
    public TelegramChat remove(TelegramChat entity) {
        return jdbcTemplate.queryForObject(
            DELETE_QUERY,
            beanPropertyRowMapper,
            entity.getId()
        );
    }

    @Override
    public Collection<TelegramChat> findAll() {
        return jdbcTemplate.query(SELECT_ALL, beanPropertyRowMapper);
    }
}
