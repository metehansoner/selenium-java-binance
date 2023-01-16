package config;

import org.aeonbits.owner.Config;
import org.aeonbits.owner.Config.LoadPolicy;
import org.aeonbits.owner.Config.LoadType;

@LoadPolicy(LoadType.MERGE)
@Config.Sources({
        "system:properties",
        "classpath:general.properties",
        "classpath:environment.properties",
        "classpath:grid.properties"})
public interface Configuration extends Config {

    @DefaultValue("test")
    String env();

    @Key("target")
    String target();

    @Key("headless")
    Boolean headless();

    @Key("timeout")
    int timeout();

    @Key("grid.url")
    String gridUrl();

    @Key("grid.port")
    String gridPort();

    @Key("servers.${env}.url")
    String url();

}
