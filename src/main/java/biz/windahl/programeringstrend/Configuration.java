package biz.windahl.programeringstrend;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Configuration extends io.dropwizard.Configuration {

    private String version;

    @JsonProperty
    public String getVersion() {
        return version;
    }

    @JsonProperty
    public void setVersion(String version) {
        this.version = version;
    }
}
