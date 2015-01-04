package biz.windahl.programeringstrend;

import biz.windahl.programeringstrend.resource.AdminResource;
import io.dropwizard.Application;
import io.dropwizard.db.DataSourceFactory;
import io.dropwizard.flyway.FlywayBundle;
import io.dropwizard.jdbi.DBIFactory;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import org.skife.jdbi.v2.DBI;

public class ProgrameringsTrendApplication extends Application<Configuration> {

    public static void main(String[] args) throws Exception {
        new ProgrameringsTrendApplication().run(args);
    }

    @Override
    public void initialize(Bootstrap<Configuration> bootstrap) {
        bootstrap.addBundle(new FlywayBundle<Configuration>() {
            @Override
            public DataSourceFactory getDataSourceFactory(Configuration configuration) {
                return configuration.getDataSourceFactory();
            }

          /*  @Override
            public FlywayFactory getFlywayFactory(Configuration configuration) {
                return configuration.getFlywayFactory();
            }*/
        });
    }

    @Override
    public void run(Configuration configuration, Environment environment) throws Exception {
        final DBIFactory factory = new DBIFactory();
        final DBI jdbi = factory.build(environment, configuration.getDataSourceFactory(), "MySql");
        environment.jersey().register(new AdminResource());
    }
}
