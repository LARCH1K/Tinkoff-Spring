/*
 * This file is generated by jOOQ.
 */

package ru.tinkoff.edu.java.scrapper.domain.jooq.tables;

import java.time.OffsetDateTime;
import java.util.function.Function;
import javax.annotation.processing.Generated;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Function2;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Records;
import org.jooq.Row2;
import org.jooq.Schema;
import org.jooq.SelectField;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.TableOptions;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.SQLDataType;
import org.jooq.impl.TableImpl;
import ru.tinkoff.edu.java.scrapper.domain.jooq.DefaultSchema;
import ru.tinkoff.edu.java.scrapper.domain.jooq.Keys;
import ru.tinkoff.edu.java.scrapper.domain.jooq.tables.records.TelegramChatRecord;

/**
 * This class is generated by jOOQ.
 */
@Generated(
    value = {
        "https://www.jooq.org",
        "jOOQ version:3.18.9"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({"all", "unchecked", "rawtypes", "this-escape"})
public class TelegramChat extends TableImpl<TelegramChatRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>TELEGRAM_CHAT</code>
     */
    public static final TelegramChat TELEGRAM_CHAT = new TelegramChat();

    /**
     * The class holding records for this type
     */
    @Override
    @NotNull
    public Class<TelegramChatRecord> getRecordType() {
        return TelegramChatRecord.class;
    }

    /**
     * The column <code>TELEGRAM_CHAT.ID</code>.
     */
    public final TableField<TelegramChatRecord, Long> ID =
        createField(DSL.name("ID"), SQLDataType.BIGINT.nullable(false), this, "");

    /**
     * The column <code>TELEGRAM_CHAT.REGISTERED_AT</code>.
     */
    public final TableField<TelegramChatRecord, OffsetDateTime> REGISTERED_AT =
        createField(DSL.name("REGISTERED_AT"), SQLDataType.TIMESTAMPWITHTIMEZONE(6).nullable(false), this, "");

    private TelegramChat(Name alias, Table<TelegramChatRecord> aliased) {
        this(alias, aliased, null);
    }

    private TelegramChat(Name alias, Table<TelegramChatRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table());
    }

    /**
     * Create an aliased <code>TELEGRAM_CHAT</code> table reference
     */
    public TelegramChat(String alias) {
        this(DSL.name(alias), TELEGRAM_CHAT);
    }

    /**
     * Create an aliased <code>TELEGRAM_CHAT</code> table reference
     */
    public TelegramChat(Name alias) {
        this(alias, TELEGRAM_CHAT);
    }

    /**
     * Create a <code>TELEGRAM_CHAT</code> table reference
     */
    public TelegramChat() {
        this(DSL.name("TELEGRAM_CHAT"), null);
    }

    public <O extends Record> TelegramChat(Table<O> child, ForeignKey<O, TelegramChatRecord> key) {
        super(child, key, TELEGRAM_CHAT);
    }

    @Override
    @Nullable
    public Schema getSchema() {
        return aliased() ? null : DefaultSchema.DEFAULT_SCHEMA;
    }

    @Override
    @NotNull
    public UniqueKey<TelegramChatRecord> getPrimaryKey() {
        return Keys.CONSTRAINT_B;
    }

    @Override
    @NotNull
    public TelegramChat as(String alias) {
        return new TelegramChat(DSL.name(alias), this);
    }

    @Override
    @NotNull
    public TelegramChat as(Name alias) {
        return new TelegramChat(alias, this);
    }

    @Override
    @NotNull
    public TelegramChat as(Table<?> alias) {
        return new TelegramChat(alias.getQualifiedName(), this);
    }

    /**
     * Rename this table
     */
    @Override
    @NotNull
    public TelegramChat rename(String name) {
        return new TelegramChat(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    @NotNull
    public TelegramChat rename(Name name) {
        return new TelegramChat(name, null);
    }

    /**
     * Rename this table
     */
    @Override
    @NotNull
    public TelegramChat rename(Table<?> name) {
        return new TelegramChat(name.getQualifiedName(), null);
    }

    // -------------------------------------------------------------------------
    // Row2 type methods
    // -------------------------------------------------------------------------

    @Override
    @NotNull
    public Row2<Long, OffsetDateTime> fieldsRow() {
        return (Row2) super.fieldsRow();
    }

    /**
     * Convenience mapping calling {@link SelectField#convertFrom(Function)}.
     */
    public <U> SelectField<U> mapping(Function2<? super Long, ? super OffsetDateTime, ? extends U> from) {
        return convertFrom(Records.mapping(from));
    }

    /**
     * Convenience mapping calling {@link SelectField#convertFrom(Class,
     * Function)}.
     */
    public <U> SelectField<U> mapping(
        Class<U> toType,
        Function2<? super Long, ? super OffsetDateTime, ? extends U> from
    ) {
        return convertFrom(toType, Records.mapping(from));
    }
}