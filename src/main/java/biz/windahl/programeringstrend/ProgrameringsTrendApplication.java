package biz.windahl.programeringstrend;

import biz.windahl.programeringstrend.resource.AdminResource;
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class ProgrameringsTrendApplication extends Application<Configuration> {

    public static void main(String[] args) throws Exception {
        new ProgrameringsTrendApplication().run(args);
    }

    @Override
    public void initialize(Bootstrap<Configuration> bootstrap) {

    }

    @Override
    public void run(Configuration configuration, Environment environment) throws Exception {
        environment.jersey().register(new AdminResource());
    }
}
