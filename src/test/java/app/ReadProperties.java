package app;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ReadProperties {
    private static final String FILE_CONFIG = "\\config.properties";
    private static ReadProperties instance = null;
    private Properties properties = new Properties();

    public static ReadProperties getInstance() {
        if (instance == null) {
            instance = new ReadProperties();
            instance.readConfig();
        }
        return instance;
    }

    private void readConfig() {
        InputStream inputStream = null;
        try {
            String currentDir = System.getProperty("user.dir");
            inputStream = new FileInputStream(currentDir + FILE_CONFIG);
            properties.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (inputStream != null) {
                    inputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public String getProperty(String key) {
        return properties.getProperty(key);
    }

}

