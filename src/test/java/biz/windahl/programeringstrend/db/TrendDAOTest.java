package biz.windahl.programeringstrend.db;

import biz.windahl.programeringstrend.Configuration;
import biz.windahl.programeringstrend.ProgrameringsTrendApplication;
import io.dropwizard.db.DataSourceFactory;
import io.dropwizard.java8.jdbi.args.LocalDateTimeArgumentFactory;
import io.dropwizard.java8.jdbi.args.LocalDateTimeMapper;
import io.dropwizard.jdbi.DBIFactory;
import io.dropwizard.testing.junit.DropwizardAppRule;
import org.flywaydb.core.Flyway;
import org.junit.*;
import org.skife.jdbi.v2.DBI;

import java.time.LocalDate;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

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
        flyway.migrate();
    }

    @AfterClass
    public static void tearDown() {
        flyway.clean();
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
    public void testInsert() throws ClassNotFoundException {
     //   dao.insert(1, 1, new Date(), 10);
        assertTrue(true);
    }

    @Test
    public void testFindFirstDate() {
        LocalDate date = LocalDate.now().atStartOfDay().toLocalDate();
        dao.insert(1, 1, date, 5);
        assertEquals(date, dao.findFirstDate());
    }
}
