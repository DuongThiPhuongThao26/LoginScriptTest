package config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigProperties {

    public String getConfig(String configName) {
        Properties prop = new Properties();
        try (InputStream input = getClass().getClassLoader().getResourceAsStream("config.properties")) {
            prop.load(input);
            return prop.getProperty(configName);
        } catch (IOException ex) {
            ex.printStackTrace();
            return "";
        }
    }
}
