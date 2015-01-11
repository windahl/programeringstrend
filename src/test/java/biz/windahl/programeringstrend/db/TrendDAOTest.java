package biz.windahl.programeringstrend.db;

import biz.windahl.programeringstrend.Configuration;
import biz.windahl.programeringstrend.ProgrameringsTrendApplication;
import biz.windahl.programeringstrend.jdbi.LocalDateTimeArgumentFactory;
import biz.windahl.programeringstrend.jdbi.LocalDateTimeMapper;
import io.dropwizard.db.DataSourceFactory;
import io.dropwizard.jdbi.DBIFactory;
import io.dropwizard.testing.junit.DropwizardAppRule;
import org.flywaydb.core.Flyway;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.ClassRule;
import org.junit.Test;
import org.skife.jdbi.v2.DBI;

import java.time.LocalDate;
import java.time.LocalDateTime;

import static org.junit.Assert.assertEquals;

public class TrendDAOTest {

    @ClassRule
    public static final DropwizardAppRule<Configuration> RULE =
            new DropwizardAppRule<Configuration>(ProgrameringsTrendApplication.class, "config-test.yml");

    private TrendDAO dao;
    private static Flyway flyway;

    @BeforeClass
    public static void setupClass() {
        flyway = new Flyway();
        DataSourceFactory dsf = RULE.getConfiguration().getDataSourceFactory();
        flyway.setDataSource(dsf.getUrl(), dsf.getUser(), dsf.getPassword());
        flyway.clean();
        flyway.migrate();
    }

    @Before
    public void setup() throws ClassNotFoundException {
        final DBIFactory factory = new DBIFactory();
        final DBI jdbi = factory.build(RULE.getEnvironment(), RULE.getConfiguration().getDataSourceFactory(), "db");
        jdbi.registerMapper(new LocalDateTimeMapper());
        jdbi.registerArgumentFactory(new LocalDateTimeArgumentFactory());
        dao = jdbi.onDemand(TrendDAO.class);
    }

    @Test
    public void testFindFirstDate() {
        LocalDateTime date = LocalDate.now().atStartOfDay();
        dao.insert(1, 1, date, 5);
        assertEquals(date, dao.findFirstDate());
    }
}
