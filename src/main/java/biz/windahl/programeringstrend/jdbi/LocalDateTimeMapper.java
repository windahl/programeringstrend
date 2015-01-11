package biz.windahl.programeringstrend.jdbi;

import org.skife.jdbi.v2.util.TypedMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;

/**
 * Replaces io.dropwizard.java8.jdbi.args.LocalDateTimeMapper until a new release has been done that works.
 */
public class LocalDateTimeMapper extends TypedMapper<LocalDateTime> {

    @Override
    protected LocalDateTime extractByName(final ResultSet r, final String name) throws SQLException {
        final Timestamp timestamp = r.getTimestamp(name);
        if (timestamp == null) {
            return null;
        }
        return timestamp.toLocalDateTime();
    }

    @Override
    protected LocalDateTime extractByIndex(final ResultSet r, final int index) throws SQLException {
        final Timestamp timestamp = r.getTimestamp(index);
        if (timestamp == null) {
            return null;
        }
        return timestamp.toLocalDateTime();
    }
}