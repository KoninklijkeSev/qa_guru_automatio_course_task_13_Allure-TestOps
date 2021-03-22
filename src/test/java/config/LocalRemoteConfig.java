package config;

import org.aeonbits.owner.Config;

@Config.Sources("classpath:local.properties")
public interface LocalRemoteConfig extends Config {

    @Key("browser")
//  @DefaultValue("chrome")
    String browser();

    @Key("version")
//  @DefaultValue("89.0")
    String version();

    @Key("remoteUrl")
    String remoteUrl();

    @Key("videoStore")
    String videoStore();
}
